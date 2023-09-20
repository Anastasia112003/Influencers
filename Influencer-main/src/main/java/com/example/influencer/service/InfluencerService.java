package com.example.influencer.service;


import com.example.influencer.model.Influencer;
import com.example.influencer.repository.InfluencerRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InfluencerService {

    private final InfluencerRepository postRepository;

    public InfluencerService(InfluencerRepository postRepository) {

        this.postRepository = postRepository;
    }

    @KafkaListener(topics = "managerToInfluencer")
    public void create(Influencer influencer) {
        postRepository.save(influencer);

    }
}



