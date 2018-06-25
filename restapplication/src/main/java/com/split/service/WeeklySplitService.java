package com.split.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.split.beans.CreateWeeklySplitBean;
import com.split.beans.WeeklySplitBean;
import com.split.entity.BOHeaderEntity;
import com.split.entity.WeeklySplitCreateEntity;
import com.split.entity.WeeklySplitEntity;
import com.split.handlers.DateHandler;
import com.split.handlers.PercentageCalculation;
import com.split.repositories.BORepository;
import com.split.repositories.CreateWeeklySplitRepository;
import com.split.repositories.WeeklySplitRepository;

@Service

@Transactional(value = "transactionManager")

public class WeeklySplitService {

	@Autowired
	BORepository boRepository;
	
	@Autowired
	WeeklySplitRepository weeklysplitrepository;
	

	// Get Week Split
	public List<WeeklySplitEntity> getWeekSplit(Integer id,String region, String cluster){
		System.out.println("getWeeklySplit bo id is " + id);
		System.out.println("region is " + region);
		System.out.println("cluster is " + cluster);
		List<WeeklySplitEntity> entities = new ArrayList<>();
		List<BOHeaderEntity> bentities = new ArrayList<>();
		WeeklySplitBean weekBean=new WeeklySplitBean();
		try{
			
			/**********Get From date and to date from BOHeader Table***********/
			System.out.println("******WeeklySplitService bo id is "+id);
			
			Iterable<BOHeaderEntity> boEntities = boRepository.findByBoid(id);
			boEntities.forEach(bentities::add);
			System.out.println("Entities size is" +bentities.size());
			System.out.println("BOHeader entity From Date " +bentities.get(0).getBO_FROM());//Tue May 01 00:00:00 IST 2018
			System.out.println("BOHeader entity TODate" +bentities.get(0).getBO_TO());//Mon May 28 00:00:00 IST 2018
			
			//Temporarily for week split,otherwise the no:of weeks would be availble in Bo Header table
			DateHandler datehandler=new DateHandler();
			int numberofWeek=datehandler.getweek(bentities.get(0).getBO_FROM(),bentities.get(0).getBO_TO());
			System.out.println("numberofWeek are "+numberofWeek);
			//weekBean.setMWEEK(numberofWeek);
			/*WeeklySplitEntity wentity=new WeeklySplitEntity();
			wentity.setMWEEK(numberofWeek);*/
			
			
			//Date validation-week split
			/*DateHandler datehandler=new DateHandler();
			//int numberofWeek=datehandler.getweek(bentities.get(0).getBO_FROM(),bentities.get(0).getBO_TO());
			if(datehandler.getvalidnumberOfweek(bentities.get(0).getBO_FROM(),bentities.get(0).getBO_TO()))
					{
						System.out.println("******WeeklySplitService IF condition******" );
						
						Iterable<WeeklySplitEntity> boWeekSplit =weeklysplitrepository.findByBoid(id, region, cluster);
						// List<WeeklySplitEntity> entities = new ArrayList<>();
						boWeekSplit.forEach(entities::add);
						System.out.println("Entities size is" +entities.size());
					}
			
				*/		
			//System.out.println("numberofWeek are "+numberofWeek);
			/************Get week split details from DB*************/
		
		if (cluster.equalsIgnoreCase("") || cluster.equalsIgnoreCase(null)) {
			System.out.println("******WeeklySplitService IF condition******" );
			Iterable<WeeklySplitEntity> boWeekSplit =weeklysplitrepository.findByidregion(id, region);
			boWeekSplit.forEach(entities::add);
		} else {
			// Iterable<WeeklySplitEntity> boWeekSplit =weeklysplitrepository.findAll();
			System.out.println("******WeeklySplitService IF condition******" );
			Iterable<WeeklySplitEntity> boWeekSplit =weeklysplitrepository.findByBoid(id, region, cluster);
			// List<WeeklySplitEntity> entities = new ArrayList<>();
			boWeekSplit.forEach(entities::add);
			System.out.println("Entities size is" +entities.size());
			}
		
		return entities;
	}
		
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return entities;
	}
	@Autowired

	CreateWeeklySplitRepository createwsplitrepo;

	// public void saveBean(WeeklySplitCreateBean bean) {

	public void saveBean(CreateWeeklySplitBean cbean) {

		List<WeeklySplitCreateEntity> lwentity = new ArrayList<WeeklySplitCreateEntity>();
		PercentageCalculation percentageCal=new PercentageCalculation();
		// List<WeeklySplitCreateEntity> lwentity2 =new
		// ArrayList<WeeklySplitCreateEntity>();
		//double calculatedpercentage=0;
		
		
		System.out.println("WeeklySplit SERVICE");// getCreateBeans

		cbean.getCreateBeans().forEach(b -> {

			WeeklySplitCreateEntity w1entity = new WeeklySplitCreateEntity();
			WeeklySplitCreateEntity w2entity = new WeeklySplitCreateEntity();
			WeeklySplitCreateEntity w3entity = new WeeklySplitCreateEntity();
			WeeklySplitCreateEntity w4entity = new WeeklySplitCreateEntity();
			
			//Percentage validation-for create weekelySplit
			int noofweek=b.getMWEEK();
			for(int i=0;i<noofweek;i++)
			{
				System.out.println("week"+i);
				w1entity.setBO_ID(b.getBO_ID());
				w1entity.setCluster(b.getCLUSTER());
				w1entity.setComponent(b.getCOMPONENT());
				w1entity.setRegion(b.getREGION());
				w1entity.setWEEK("W"+i);
				if(b.getWeek1_Percent()!=0)
					{
						w1entity.setPERCENT(b.getWeek1_Percent());
						double wcalculatedpercentage=percentageCal.getweekPercentage(b.getWeek1_Percent(),b.getQunatity());
						System.out.println("calculatedpercentage" +wcalculatedpercentage);
						b.setWeek1_Quantity(wcalculatedpercentage);
						
					}
				
				//w1entity.setPERCENT(c.getWeek1_Percent());
				
				
				
				
				
				/*System.out.println("week"+i);
				w2entity.setBO_ID(b.getBO_ID());
				w2entity.setCluster(b.getCLUSTER());
				w2entity.setComponent(b.getCOMPONENT());
				w2entity.setRegion(b.getREGION());
				w2entity.setWEEK("W2");
				w2entity.setPERCENT(b.getWeek2_Percent());
				double w2calculatedpercentage=percentageCal.getweekPercentage(b.getWeek1_Percent(),b.getQunatity());
				System.out.println("calculatedpercentage" +w2calculatedpercentage);
				b.setWeek1_Quantity(w2calculatedpercentage);*/
				
			}
			

			//if (b.getWeek1_Percent() != 0) {

				System.out.println("week1");
				w1entity.setBO_ID(b.getBO_ID());
				w1entity.setCluster(b.getCLUSTER());
				w1entity.setComponent(b.getCOMPONENT());
				w1entity.setRegion(b.getREGION());
				w1entity.setWEEK("W1");
				w1entity.setPERCENT(b.getWeek1_Percent());
				w1entity.setQunatity(b.getWeek1_Quantity());
				lwentity.add(w1entity);

				System.out.println("entity Size in W1" + lwentity.size());

			//}

			//if (b.getWeek2_Percent() != 0) {

				System.out.println("week2");
				w2entity.setBO_ID(b.getBO_ID());
				w2entity.setCluster(b.getCLUSTER());
				w2entity.setComponent(b.getCOMPONENT());
				w2entity.setRegion(b.getREGION());
				w2entity.setWEEK("W2");
				w2entity.setPERCENT(b.getWeek2_Percent());
				w2entity.setQunatity(b.getWeek2_Quantity());
				lwentity.add(w2entity);

				// createwsplitrepo.save(lwentity);

				System.out.println("entity Size in W2" + lwentity.size());

			//}

			//if (b.getWeek3_Percent() != 0) {

				System.out.println("week3");
				w3entity.setBO_ID(b.getBO_ID());
				w3entity.setCluster(b.getCLUSTER());
				w3entity.setComponent(b.getCOMPONENT());
				w3entity.setRegion(b.getREGION());
				w3entity.setWEEK("W3");
				w3entity.setPERCENT(b.getWeek3_Percent());
				w3entity.setQunatity(b.getWeek3_Quantity());
				lwentity.add(w3entity);
				// createwsplitrepo.save(lwentity);
				System.out.println("entity Size in W3" + lwentity.size());

			//}

			//if (b.getWeek4_Percent() != 0) {
				System.out.println("week4");
				w4entity.setBO_ID(b.getBO_ID());
				w4entity.setCluster(b.getCLUSTER());
				w4entity.setComponent(b.getCOMPONENT());
				w4entity.setRegion(b.getREGION());
				w4entity.setWEEK("W4");
				w4entity.setPERCENT(b.getWeek4_Percent());
				w4entity.setQunatity(b.getWeek4_Quantity());
				lwentity.add(w4entity);
				// createwsplitrepo.save(lwentity);

				//

				System.out.println("entity Size in W4" + lwentity.size());

			//}

			// lwentity2.addAll(lwentity);

		});

		System.out.println("List Size" + lwentity.size());
		for (int j = 0; j < lwentity.size(); j++)

		{
			/*System.out.println("j====" + j);
			System.out.println("Percent" + lwentity.get(j).getPERCENT());
			System.out.println("Quantity" + lwentity.get(j).getQunatity());
			System.out.println("ID" + lwentity.get(j).getBO_ID()); // .entity.getCluster());
			System.out.println("Cluster" + lwentity.get(j).getCluster());
			System.out.println("Region" + lwentity.get(j).getRegion());
			System.out.println("WEEK" + lwentity.get(j).getWEEK());
			System.out.println("Component" + lwentity.get(j).getComponent());*/
			createwsplitrepo.save(lwentity.get(j));
		}

		System.out.println("After All if-----" + lwentity.size());
		System.out.println("***************Update Sucessfully for all list************");
	}
	
}