package com.data.service;

import com.data.repository.ReviewDAO;
import com.data.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewDAO reviewDAO;

    public ReviewService(ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;
    }

    public List<Review> getByProductId(Long idProduct) {
        return reviewDAO.findByProductId(idProduct);
    }

    public void save(Review review) {
        reviewDAO.save(review);
    }
}
