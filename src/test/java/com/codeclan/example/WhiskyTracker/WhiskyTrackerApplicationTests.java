package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void cangetAllWhiskiesByYear(){
		List<Whisky> found = whiskyRepository.getWhiskeysByYear(2018);
		assertEquals(2, found.size());
	}

	@Test
	public void canGetDistilleriesByRegion(){
		List<Distillery> found = distilleryRepository.getDistilleriesByRegion("Speyside");
		assertEquals(2, found.size());
	}

	@Test
	public void cangetWhiskyFromDistilleryByAge(){
		List<Whisky> found = whiskyRepository.getAllWhiskyFromDistilleryByAge(1L, 15);
		assertEquals(1, found.size());
	}

	@Test
	public void getAllWhiskyFromRegion(){
		List<Whisky> found = whiskyRepository.getAllWhiskyByDistilleryRegion("Highland");
		assertEquals(2, found.size());
	}

	@Test
	public void canGetDistilleriesByWhiskyAge(){
		List<Distillery> found = distilleryRepository.getAllDistilleriesWithWhiskyOfAge(12);
		assertEquals(2, found.size());
	}

}
