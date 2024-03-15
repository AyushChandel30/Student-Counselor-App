package in.ayush.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ayush.binding.SearchCriteria;
import in.ayush.entity.StudentEnq;
import in.ayush.service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {
	@Autowired
	private EnquiryService enqService;
//===============================================================================
	@GetMapping ("/enquiry")
	public String enqPage(Model model) {
		model.addAttribute("enq", new StudentEnq());
		return "addEnqView";
	}

	@PostMapping ("/enquiry")
	public String addEnquiry(@ModelAttribute ("enq") StudentEnq enq, HttpServletRequest req, Model model) {
		
		HttpSession session = req.getSession(false);
		Integer cid = (Integer) session.getAttribute("CID");
		//CID is the session which we have created in handleLogin() method in CounsellorController
		if (cid == null) {
			return "redirect:/logout";
		}//this is because when we logout, it should go to /logout where we are trying to expire session
		
		enq.setCid(cid);
		
		boolean addEnq = enqService.addEnq(enq);
		if (addEnq) {
			model.addAttribute("succMsg", "Enquiry Added");
		} else {
			model.addAttribute("errMsg", "Enquiry Failed To Add");
		}
		return "redirect:/enquiry";
	}
//===============================================================================

	@GetMapping ("/enquiries")
	public String viewEnquiries(HttpServletRequest req, Model model) {
		
		HttpSession session = req.getSession(false);
		Integer cid = (Integer) session.getAttribute("CID");
		if (cid == null) {
			return "redirect:/logout";
		}
		
		SearchCriteria sc = new SearchCriteria();
		model.addAttribute("sc", sc);
		
		List<StudentEnq> enquiriesList = enqService.getEnquiries(cid, sc);
		model.addAttribute("enquiriesKey", enquiriesList);
		return "displayEnqView";
	}
//===============================================================================

	@PostMapping ("/filter-enquiries")
	public String filterEnquiries(@ModelAttribute ("sc") SearchCriteria sc, HttpServletRequest req,  Model model) {
		
		HttpSession session = req.getSession(false);
		Integer cid = (Integer) session.getAttribute("CID");
		if (cid == null) {
			return "redirect:/logout";
		}
		
		List<StudentEnq> enquiriesList = enqService.getEnquiries(cid, sc);
		model.addAttribute("enquiriesKey", enquiriesList);
		return "filterEnqView";
	}

	
}
