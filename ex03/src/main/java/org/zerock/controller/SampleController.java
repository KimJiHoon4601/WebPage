package org.zerock.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.extern.log4j.Log4j;



@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {

	@GetMapping(value="/getText" , produces="text/plain; charset=UTF-8")
	public String getText() {
		log.info("MiMe Type : " + MediaType.TEXT_PLAIN_VALUE);
		
		return "�ȳ��ϼ���";
	}
	
	
	@GetMapping(value="/getSample" , 
		    produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,
		    		   MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112,"��Ÿ" , "�ε�");
	}
	
	
	@GetMapping(value="/getSample2") 
	public SampleVO getSample2() {
		return new SampleVO(112,"��Ÿ" , "�ε�");
	}
	
	@GetMapping(value="/getList") 
	public List<SampleVO> getList() {
		
		List<SampleVO> li = new ArrayList<SampleVO>();
		
		
		for(int i=0; i<10; i++) {
			SampleVO sa = new SampleVO(i,i+"",i+"");
			li.add(sa);
		}
		
		return li;
		
	}
	
	@GetMapping(value="/getMap") 
	public Map<String, SampleVO> getMap() {
		
		Map<String, SampleVO> map = new LinkedHashMap<String, SampleVO>();
		
		
		for(int i=0; i<10; i++) {
			SampleVO sa = new SampleVO(i,i+"",i+"");
			map.put(i+"", sa);
		}
		
		return map;
		
	}
	
	
	@GetMapping(value = "/check", params = { "height", "weight" })
	public ResponseEntity<SampleVO> check(Double height, Double weight) {

		SampleVO vo = new SampleVO(000, "" + height, "" + weight);

		ResponseEntity<SampleVO> result = null;

		if (height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}

		return result;
	}
	
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {

		return new String[] { "category: " + cat, "productid: " + pid };
	}
	
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {

		log.info("convert.......ticket" + ticket);

		return ticket;

	}
	
	
}