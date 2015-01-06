/**
 * 
 */
package com.demo2do.arizona.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo2do.arizona.entity.security.Principal;
import com.demo2do.arizona.entity.security.Team;
import com.demo2do.arizona.entity.stat.PrincipalWorkSheetStat;
import com.demo2do.arizona.entity.work.calendar.MonthlyCalendar;
import com.demo2do.arizona.entity.work.plan.WorkPlan;
import com.demo2do.arizona.entity.work.sheet.WorkSheet;
import com.demo2do.arizona.service.CalendarService;
import com.demo2do.arizona.service.StatService;
import com.demo2do.arizona.service.TeamService;
import com.demo2do.arizona.service.WorkPlanService;
import com.demo2do.arizona.service.WorkSheetService;
import com.demo2do.core.web.interceptor.MenuSetting;
import com.demo2do.core.web.resolver.Secure;

/**
 * @author Downpour
 */
@Controller
@MenuSetting("menu-home")
public class HomeController {
	
	@Autowired
	private CalendarService calendarService;
	
	@Autowired
	private WorkPlanService workPlanService;
	
	@Autowired
	private WorkSheetService workSheetService;
	
	@Autowired
	private StatService statService;
	
	@Autowired
	private TeamService teamService;

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/home")
	public ModelAndView home(@Secure Principal principal) {
		
		ModelAndView modelAndView = new ModelAndView("home/home");
		
		// 1. current month / workingDays in current month ( this is for many stat header display )
		if(!principal.hasAnyPrincipalRole("ROLE_SALES")) {
			MonthlyCalendar monthlyWorkingCalendar = calendarService.getWorkingMonthCalendar(new Date());  
			modelAndView.addObject("monthlyCalendar", monthlyWorkingCalendar);
		}
		
		// 2. managed teams ( this is for some work sheet header to filter teams ) returns from Principal
		if(principal.hasAnyPrincipalRole("ROLE_SALES_MANAGER", "ROLE_DEPARTMENT_MANAGER", "ROLE_PRESIDENT", "ROLE_SUPER_USER", "ROLE_SALES_EXECUTIVE")) {
			List<Team> teams = teamService.getSubordinateTeams(principal);
			modelAndView.addObject("teams", teams);
		}
		
		return modelAndView;
	}
	
	/**
	 * This will be for sales to see his own workplan state
	 * 
	 * @return
	 */
	@RequestMapping("/home/sales/work-plan")
	public ModelAndView calculateMonthlyWorkPlanStat(@Secure Principal principal) {
		
		// load monthlyCalendar and workplan list
		
		ModelAndView modelAndView = new ModelAndView("home/sales/work-plan-partial");
		
		MonthlyCalendar monthlyWorkingCalendar = calendarService.getWorkingMonthCalendar(new Date());
		
		// get work plans according to the calculated working month
		List<List<WorkPlan>> monthlyWorkPlans = workPlanService.listMonthlyWorkPlans(principal, monthlyWorkingCalendar);
		
		modelAndView.addObject("monthlyWorkingCalendar", monthlyWorkingCalendar);
		modelAndView.addObject("monthlyWorkPlans", monthlyWorkPlans);
		
		return modelAndView;
	}
	
	/**
	 * This will be for sales to see his own worksheet stat
	 * 
	 * @param principal
	 * @return
	 */
	@RequestMapping("home/sales/work-sheet")
	public ModelAndView calculateMonthlyWorkSheetStat(@Secure Principal principal) {
		
		ModelAndView modelAndView = new ModelAndView("home/sales/work-sheet-partial");
		
		MonthlyCalendar monthlyWorkingCalendar = calendarService.getWorkingMonthCalendar(new Date());
		
		// get work sheet according to the calculated working month
		List<List<WorkSheet>> monthlyWorkSheets = workSheetService.listMonthlyWorkSheets(principal, monthlyWorkingCalendar);
		
		modelAndView.addObject("monthlyWorkingCalendar", monthlyWorkingCalendar);
		modelAndView.addObject("monthlyWorkSheets", monthlyWorkSheets);
		
		return modelAndView;
	}
	
	/**
	 * This will be for manager ( above ) to see their team worksheet stat
	 * 
	 * @param principal
	 * @param team
	 * @return
	 */
	@RequestMapping("home/manager/work-sheet-stat")
	public ModelAndView calculateMonthlyWorkSheetState(@Secure Principal principal, @RequestParam("teamCode") int teamCode) {
		
		ModelAndView modelAndView = new ModelAndView("home/manager/stat-partial");
		
		MonthlyCalendar monthlyCalendar = calendarService.getWorkingMonthCalendar(new Date());
		List<PrincipalWorkSheetStat> principalWorkSheetStats = statService.getMonthlyTeamWorkSheetStat(teamCode, monthlyCalendar);
		
		modelAndView.addObject("principalWorkSheetStats", principalWorkSheetStats);
		
		return modelAndView;
	}
	
	/**
	 * This will be for manager ( above ) to see their team business trip stat
	 * 
	 * @param principal
	 * @param team
	 * @return
	 */
	@RequestMapping("home/manager/business-trip-stat")
	public ModelAndView calculateMonthlyBusinessTripState(@Secure Principal principal, @RequestParam("teamCode") int teamCode) {
		
		ModelAndView modelAndView = new ModelAndView("home/manager/business-trip-partial");
		
		MonthlyCalendar monthlyCalendar = calendarService.getWorkingMonthCalendar(new Date());
		List<PrincipalWorkSheetStat> principalWorkSheetStats = statService.getMonthlyTeamWorkSheetStat(teamCode, monthlyCalendar);
		
		modelAndView.addObject("principalWorkSheetStats", principalWorkSheetStats);
		modelAndView.addObject("monthlyCalendar", monthlyCalendar);
		
		return modelAndView;
		
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/business")
	public String business() {
		return "redirect:/projects";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/report")
	public String report() {
		return "redirect:/report/production-forecasts";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/data")
	public String data() {
		return "redirect:/product-attribute-values";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/system")
	public String system() {
		return "redirect:/messages";
	}
	
}
