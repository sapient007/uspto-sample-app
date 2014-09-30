package io.pivotal.demo.patent.controller;

import io.pivotal.demo.patent.internal.Patent;
import io.pivotal.demo.patent.internal.SearchCriteria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class PatentController {
	private static final Logger logger = LoggerFactory.getLogger(PatentController.class);
	@Autowired private io.pivotal.demo.patent.internal.PatentRepository patentRepository;
	
	@RequestMapping
	public ModelAndView main() {
		return new ModelAndView("patents/main");
	}
	
	@RequestMapping(value = "patents/search", method = RequestMethod.GET)
	public String list(SearchCriteria criteria, Model model) {
		logger.info("Searching for {}", criteria.toString());
		Page<Patent> pageOfResults = patentRepository.findByTitleContainingOrSummaryContaining(criteria.getSearchString(), criteria.getSearchString(),
													new PageRequest(criteria.getPage(), criteria.getPageSize()));
		model.addAttribute("patentList", pageOfResults.getContent());
		return "patents/list";
	} 
	
	@RequestMapping(value = "patents/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Long id, Model model) {
		logger.info("Showing patent {}", id);
		model.addAttribute("patent", patentRepository.findOne(id));
		return "patents/show";
    }

	@RequestMapping(value = "patents", method = RequestMethod.GET)
	public String createForm(SearchCriteria searchCriteria) {
		logger.info("Setting up search form...");
		return "patents/search";
	}
	
	/**
	 * Action to initiate shutdown of the system.  In CF, the application 
	 * <em>should</em>f restart.  In other environments, the application
	 * runtime will be shut down.
	 */
	@RequestMapping(value = "kill", method = RequestMethod.GET)
	public void kill() {
		logger.warn("*** The system is shutting down. ***");
		System.exit(-1);
	}
}
