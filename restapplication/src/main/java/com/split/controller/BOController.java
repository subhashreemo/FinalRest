package com.split.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.split.beans.BOHeaderBean;
import com.split.beans.BOItemBean;
import com.split.beans.BuyingOrderSplitBean;
import com.split.beans.ClusterBean;
import com.split.beans.CreateWeeklySplitBean;
import com.split.beans.RegionBean;
import com.split.beans.WeeklySplitBean;
import com.split.entity.BOHeaderEntity;
import com.split.entity.BOItemEntity;
import com.split.entity.BuyingCenterEntity;
import com.split.entity.ClusterEntity;
import com.split.entity.RegionEntity;
import com.split.entity.WeeklySplitEntity;
import com.split.service.BOItemService;
import com.split.service.BOService;
import com.split.service.BuyingOrderSplitService;
import com.split.service.ClusterService;
import com.split.service.RegionService;
import com.split.service.WeeklySplitService;

@RestController
@RequestMapping("/BOService")
public class BOController {
	/*	http://localhost:8181/restapplication/rest/BOService/list
		http://localhost:8181/restapplication/rest/BOService/create*/
	@Autowired
	BOService boService;
	
	@RequestMapping(method =  RequestMethod.GET,value="/list", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<BOHeaderBean>> getAll() {
		List<BOHeaderEntity> boEntities = boService.getAllBO();
		List<BOHeaderBean> boBeans = new ArrayList<>(boEntities.size());
		boEntities.forEach(b -> {
			boBeans.add(new BOHeaderBean(b));
		});
		return new ResponseEntity<List<BOHeaderBean>>(boBeans, HttpStatus.OK);			
	}
	
	//@RequestMapping(method =  RequestMethod.POST,value="/create", consumes= MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(method =  RequestMethod.POST,value="/create", consumes= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> createBO(@RequestBody BOHeaderBean bean) {
		System.out.println("createBO request data");
		boolean validweek=boService.saveBean(bean);
		System.out.println("validweek is "+validweek);
		if(validweek==true){
			System.out.println("Created Successfully status is "+validweek);
		return new ResponseEntity<String>("Created Successfully",HttpStatus.CREATED);
		}
		else{
			System.out.println("Date Invalid status is "+validweek);
			return new ResponseEntity<String>("Date Invalid",HttpStatus.BAD_REQUEST);
		}
	}
	//Update WeekelySplit
	@Autowired
	WeeklySplitService splitservice;
	@RequestMapping(method =  RequestMethod.POST,value="/updatewsplit", consumes= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> createSplit(@RequestBody CreateWeeklySplitBean bean) {
		System.out.println("Update WeekelySplit");
		splitservice.saveBean(bean);
		return new ResponseEntity<String>("Update Split Successfully",HttpStatus.CREATED);			
	}
	//get BO Items
	@Autowired
	BOItemService boitemservice;
		@RequestMapping(method =  RequestMethod.GET,value="/BOItems/{bo_id}",produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<List<BOItemBean>> geBOItem(@PathVariable("bo_id") Integer bo_id) {
			System.out.println("getAllBOItem bo id is "+bo_id);
			List<BOItemEntity> boItemEntities = boitemservice.getAllBOItem(bo_id);
			
			List<BOItemBean> boBeans = new ArrayList<>(boItemEntities.size());
			boItemEntities.forEach(b -> {
				boBeans.add(new BOItemBean(b));
			});
			return new ResponseEntity<List<BOItemBean>>(boBeans, HttpStatus.OK);			
		}
		
		//Get the List of regions 	
		@Autowired
		RegionService regionService;
		@RequestMapping(method =  RequestMethod.GET,value="/regions", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<List<RegionBean>> getRegion() { //
			List<RegionEntity> regionEntity = regionService.getAllRegions();
			List<RegionBean> regionBeans = new ArrayList<>(regionEntity.size());
			regionEntity.forEach(b -> {
				regionBeans.add(new RegionBean(b));
			});
			return new ResponseEntity<List<RegionBean>>(regionBeans, HttpStatus.OK);			
		}

		//Get the List of Buying Order Split
		@Autowired
		BuyingOrderSplitService bosplitservice;
		@RequestMapping(method =  RequestMethod.GET,value={"/BuyingOrderSplit/{bo_id}/{region}/{cluster}","/BuyingOrderSplit/{bo_id}/{region}"}, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		//public ResponseEntity<List<BuyingOrderSplitBean>> getBuyingOrderSplit(@PathVariable("bo_id") Integer bo_id,@PathVariable("region") String region,@PathVariable("cluster") String cluster) {
		public ResponseEntity<List<BuyingOrderSplitBean>> getBuyingOrderSplit(@PathVariable("bo_id") Integer bo_id,@PathVariable("region") String region,
				@PathVariable Optional<String> cluster) {
			//List<BuyingCenterEntity> boSplitentity = bosplitservice.getBOSplit(bo_id,region,cluster);
			List<BuyingCenterEntity> boSplitentity = bosplitservice.getBOSplit(bo_id,region,cluster.isPresent()?cluster.get():"cluster");
			List<BuyingOrderSplitBean> boSplitBeans = new ArrayList<>(boSplitentity.size());
			boSplitentity.forEach(b -> {
				boSplitBeans.add(new BuyingOrderSplitBean(b));
				
			});
			return new ResponseEntity<List<BuyingOrderSplitBean>>(boSplitBeans, HttpStatus.OK);			
		}
		
		// Get the List of Weekely Split
		@Autowired
		WeeklySplitService weeksplitservice;
		//@RequestMapping(method =  RequestMethod.GET,value="/WeeklySplit", produces = MediaType.APPLICATION_JSON_VALUE)
		//@RequestMapping(method =  RequestMethod.GET,value="/WeeklySplit/{bo_id}/{region}/{cluster}",produces = MediaType.APPLICATION_JSON_VALUE)
		@RequestMapping(method =  RequestMethod.GET,value={"/WeeklySplit/{bo_id}/{region}/{cluster}","/WeeklySplit/{bo_id}/{region}"}, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		//public ResponseEntity<List<WeeklySplitBean>> getWeeklySplit(@PathVariable("bo_id") Integer bo_id,@PathVariable("region") String region,@PathVariable("cluster") String cluster) {
		public ResponseEntity<List<WeeklySplitBean>> getWeeklySplit(@PathVariable("bo_id") Integer bo_id,@PathVariable("region") String region,
				@PathVariable Optional<String> cluster) {
			System.out.println("getWeeklySplit bo id is "+bo_id);
			System.out.println("region is "+region);
			System.out.println("cluster is "+cluster);
			WeeklySplitBean wbean=new WeeklySplitBean();
			
			//List<WeeklySplitEntity> boWeekSplitentity = weeksplitservice.getWeekSplit(bo_id,region,cluster);
			//List<WeeklySplitEntity> boWeekSplitentity =  weeksplitservice.getWeekSplit(bo_id,region,cluster.isPresent()?cluster.get():"cluster");
			List<WeeklySplitEntity> boWeekSplitentity =  weeksplitservice.getWeekSplit(bo_id,region,cluster.isPresent()?cluster.get():"");
			List<WeeklySplitBean> wboSplitBeans = new ArrayList<>(boWeekSplitentity.size());
			boWeekSplitentity.forEach(b -> {
				wboSplitBeans.add(new WeeklySplitBean(b));
				//wboSplitBeans.add(wbean.getMWEEK());
			});
			return new ResponseEntity<List<WeeklySplitBean>>(wboSplitBeans, HttpStatus.OK);			
		}
		
		// Get the Cluster Data
		@Autowired
		ClusterService clusterService;
		@RequestMapping(method =  RequestMethod.GET,value="/Clusters", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<List<ClusterBean>> getCluster() {
			List<ClusterEntity> Clusterentity = clusterService.getCluster();
			List<ClusterBean> clusterBeans = new ArrayList<>(Clusterentity.size());
			Clusterentity.forEach(b -> {
				clusterBeans.add(new ClusterBean(b));
			});
			return new ResponseEntity<List<ClusterBean>>(clusterBeans, HttpStatus.OK);			
		}
		
		
}

