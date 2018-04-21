package com.fwx.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fwx.common.PageInfo;
import com.fwx.common.ReturnInfo;
import com.fwx.domain.BalanceAndPayment;
import com.fwx.service.IbalanceAndPaymentService;
import com.fwx.vo.PerformanceVO;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/balanceAndPayment")
public class BalanceAndPaymentController {

	Logger log = (Logger) LoggerFactory.getLogger(BalanceAndPaymentController.class);

	@Autowired
	private IbalanceAndPaymentService balanceAndPaymentService;
	/**
	 * 添加套系信息
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ReturnInfo<BalanceAndPayment> add(BalanceAndPayment pcData) throws Exception{
		ReturnInfo<BalanceAndPayment> ret = new ReturnInfo<>();
		log.info("从前端获取的数据:"+pcData.toString());
		Boolean result = balanceAndPaymentService.insert(pcData);
		if(result == true){
			ret.setResult(200);
		}else{
			ret.setResult(202);
		}
		return ret;
	}




	@RequestMapping("/datagrid")
	@ResponseBody
	public ReturnInfo<PageInfo<BalanceAndPayment>> dataGrid(Integer pageNumber, Integer pageSize, String bpName){

		ReturnInfo<PageInfo<BalanceAndPayment>> result = new ReturnInfo<>();
		PageInfo<BalanceAndPayment> memberData = balanceAndPaymentService.selectAll(pageNumber, pageSize, bpName);

		log.info("获取折扣方案列表数据："+memberData.toString());

		result.setData(memberData);
		return result;
	}



}
