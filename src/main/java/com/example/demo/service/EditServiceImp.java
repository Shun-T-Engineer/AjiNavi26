package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditServiceImp implements EditService {
	
	private final ReviewRepository repository;

	@Override
	public void edit(Review review) {

		repository.update(review);

	}

}
