package com.amazonaws.sqsqueue;

import java.util.Random;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueRequest;

public class AWSApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String queue = "";
		Random r = new Random();
		for(int i=1; i<20; i++) {
			queue += "_"+1;
		}
		queue = (String) queue.subSequence(0, queue.length()-2);
		
		AmazonSQS requestQueue = AmazonSQSClientBuilder.standard()
				.withRegion(Regions.US_WEST_2)
				.build();
		
		CreateQueueRequest createRequest = new CreateQueueRequest(queue);
		
		try {
			requestQueue.createQueue(createRequest);
		} catch (AmazonSQSException e) {
			e.printStackTrace();
		}
		
	}

}
