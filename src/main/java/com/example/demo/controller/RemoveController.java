package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Review;
import com.example.demo.form.ReviewRemoveForm;

@Controller
public class RemoveController {
	
	@PostMapping("/remove-review")
	public String removeReview(@Validated @ModelAttribute ReviewRemoveForm form, 
													BindingResult result) {
		
		System.out.println(form);

		if(result.hasErrors()) {
			throw new IllegalArgumentException("**removeReview()**");
		}
		
		return "confirm-remove-review";
	}
	
	@PostMapping("/confirm-remove-review")
	public String confirmRemoveReview(@Validated ReviewRemoveForm form,
			BindingResult result, RedirectAttributes redirectAttributes){
	
		if(result.hasErrors()) {
			throw new IllegalArgumentException("**removeReview()**");
		}
		
		Review r = new Review();
		r.setReviewId(form.getReviewId());
		r.setRestaurantId(form.getRestaurantId());
		r.setUserId(form.getUserId());
		r.setVisitDate(form.getVisitDate());
		r.setRating(form.getRating());
		r.setComment(form.getComment());
		
		System.out.println(r);
		
		redirectAttributes.addFlashAttribute("msg","レビュー削除");
		
		return "redirect:/complete";
	}
}
