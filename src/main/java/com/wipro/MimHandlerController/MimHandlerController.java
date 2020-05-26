package com.wipro.MimHandlerController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wipro.Entity.data;
import com.wipro.service.DataService;
import com.wipro.util.MimHandlerConstant;


@Controller
@RequestMapping("/mimhandler")
public class MimHandlerController {

	private static final Logger logger = LoggerFactory.getLogger(MimHandlerController.class);
	
	private String outageStatusChoice="";
	
	private char uploadStatus;
	
	private List<String> selectedCountries;
	
	@Value("${uploadDirectoryPath}")
	private String uploadDirectory;
	
	@Autowired
	private DataService dataService;
	
	@RequestMapping("index")
	public Model test(Model mv) {
		System.out.println("hittin");
		//mv.addAttribute("datas",service.getDatas());
		mv.addAttribute("index1");
		//mv.setViewName("index1");
		return mv;
	}
	
	@RequestMapping("/test")
	public ModelAndView getLanguage(ModelAndView mv) throws JsonProcessingException {
		mv.addObject("datas",dataService.getDatas());
		for (data data : dataService.getDatas()) {
			System.out.println(data.getName()+";"+data.getNumber());
		}
		
		dataService.getDatas().forEach(data -> {
			System.out.println(data.getName()+ " : " + data.getNumber());
			});
		mv.setViewName("tests");
		/*List<data> list = new ArrayList<data>(service.getDatas());
		list.forEach((m)->{
			
		});*/
	 return mv;
	 }
	
	@RequestMapping("/input")
	public ModelAndView getChoice(ModelAndView model ) {
		//System.out.println(model.getViewName());
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping("/home")
	public ModelAndView getLanguage(String statusChoice, ModelAndView mv) throws JsonProcessingException {
		logger.info("--------New Request------");
		List<String> distinctLanguage = (List<String>) dataService.selectDistinctLanguage();
		outageStatusChoice = statusChoice;
		logger.info("Setting agent choice for outage choice as: " + outageStatusChoice);
		logger.info("Fetching languages :" + distinctLanguage);
		if (outageStatusChoice.equals(MimHandlerConstant.ENABLE_CHOICE))
			uploadStatus = 'Y';
		else
			uploadStatus = 'N';
		mv.addObject("distinctLanguage", distinctLanguage);
		System.out.println("/home view:" + mv.getViewName());
		mv.setViewName("home");
		
		return mv;
	}
	
	@RequestMapping("/selectCountries")
	public ModelAndView getCountries(@PathParam("language") String language, ModelAndView mv) throws JsonProcessingException {
		logger.info("language selected from selectCountries :"+language);
		
		List<String> countryList=dataService.selectCountry(language);
		
		logger.info("Country list for language {} are:"+countryList,language);
		
		mv.addObject("countryList",countryList);
		mv.addObject("outageStatusChoice",outageStatusChoice);
		mv.setViewName("selectCountries");
		
		return mv;
	}
	
	@RequestMapping("/fileUpload")
	public ModelAndView uploadFile(@RequestParam(value="selectedCountries[]") String[] countries,ModelAndView mv) {
		selectedCountries=Arrays.asList(countries);
		logger.info("Countries selected from selectCountry page are:"+selectedCountries);
		mv.addObject(countries);
		mv.setViewName("fileUpload");
		return mv;
	}
	
	@RequestMapping("/uploadAction")
	public ModelAndView upload(HttpServletRequest request,ModelAndView mv,@RequestParam("files") MultipartFile promptFile,RedirectAttributes redirectAttributes) throws Exception {
		logger.info("Parent file upload path from app properties:"+uploadDirectory);
        RedirectView redir=new RedirectView(request.getContextPath()+"/mimhandler/uploadStatus");
		if (promptFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            logger.info("selected file is empty");
            mv.setView(redir);
            return mv;
        }
		try {
			logger.info("propmt file selected is:"+promptFile.getOriginalFilename());
	        byte[] bytes = promptFile.getBytes();
	        Iterator<String> iterator = selectedCountries.iterator(); 
	        while (iterator.hasNext()){
	        	String country=iterator.next().toString();
	        	if(uploadStatus=='Y') {
	        	Path path = Paths.get(uploadDirectory +country+"/"+ promptFile.getOriginalFilename());
	        	Files.write(path, bytes);
	        	logger.info("Prompt file uploaded in :"+ path);
	        	dataService.updateStatus(uploadStatus,country); 
	        	}
	        }
	        logger.info("All files updated.Redirecting to uploadStatus");
        	redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + promptFile.getOriginalFilename() + "'");
        	mv.setView(redir);
		} catch (IOException e) {
			System.out.println("Could not upload prompt file "+ e.getLocalizedMessage());
	            e.printStackTrace();
	        }
		return mv;
	}
	
	/**
	 * 
	 * @param mv
	 * @return
	 */
	@RequestMapping("/uploadStatus")
    public ModelAndView uploadStatus(ModelAndView mv) {
		mv.setViewName("uploadStatus");
	return mv;
    }
	
	/**
	 * 
	 * @param request
	 * @param mv
	 * @param countries
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("/disableOutageStatus")
	public ModelAndView disableStatus(HttpServletRequest request,ModelAndView mv,@RequestParam(value="selectedCountries[]") String[] countries,RedirectAttributes redirectAttributes) {
		selectedCountries=Arrays.asList(countries);
        RedirectView redir=new RedirectView(request.getContextPath()+"/mimhandler/uploadStatus");
		logger.info("countries selected for disabling status:"+selectedCountries);
		Iterator<String> iterator = selectedCountries.iterator();
		while(iterator.hasNext()) {
			String country=iterator.next();
			if(uploadStatus=='N') {
				logger.info("Updating outage status {} for country:{}",uploadStatus,country);
				dataService.updateStatus(uploadStatus,country);
			}
		}
		logger.info("Redirecting to uploadStatus");
		redirectAttributes.addFlashAttribute("message", "You successfully disabled the status" );
		mv.setView(redir);
		return mv;
		}
}
