package com.cr.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cr.common.FileUtils;
import com.cr.common.PageInfo;
import com.cr.common.QRCodeUtils;
import com.cr.common.ReturnInfo;
import com.cr.common.UUIDUtils;
import com.cr.domain.Goods;
import com.cr.service.impl.GoodsService;

@RestController
@RequestMapping("/business")
public class BusinessController {
	@Resource
	private GoodsService goodsService;
	@RequestMapping(value="/addproduce",method=RequestMethod.POST)
	public ReturnInfo<Goods> addproduce(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request) throws UnsupportedEncodingException, IOException{
		ReturnInfo<Goods> ret = new ReturnInfo<Goods>();
		String goodsName = request.getParameter("goodsName");
		String goodsAddress = request.getParameter("goodsAddress");
		String goodsPrice = request.getParameter("goodsPrice");
		String goodsType = request.getParameter("goodsType");
		String goodsContent = request.getParameter("content");
		if("".equals(goodsName) | "".equals(goodsAddress) | "".equals(goodsPrice) | "".equals(goodsType)){
			ret.setResult(201);
			return ret;
		}
		Goods goods = new Goods();
		goods.setId(UUIDUtils.getUuid32());
		goods.setGoodsName(goodsName);
		goods.setGoodsPrice(goodsPrice);
		goods.setGoodsProducer(request.getSession().getAttribute("businessname").toString());
		goods.setGoodsPlace(goodsAddress);
		goods.setGoodsType(goodsType);
		goods.setCreateTime(new Date());
		goods.setContent(goodsContent);
		
		goods.setDelFlag("0");
		String filePath = request.getSession().getServletContext().getRealPath("goods/");
		if(file.isEmpty() == false){
		    
		    //判断文件大小，30kb~1024kb
		    if(file.getSize() < 30000 || file.getSize() > 1048576){
		        ret.setMsg("文件大小在30KB~1MB之间");
		        ret.setResult(201);
		        return ret;
		    }
		    
			String fileName =  UUID.randomUUID()+file.getOriginalFilename();
			
			try {
			    FileUtils.uploadFile(file.getBytes(), filePath, fileName);
			} catch (Exception e) {
			        
			}
			goods.setGoodsImg(fileName);
		}else{
			ret.setResult(202);
			return ret;
		}
		String qrData = "【商品名称：】" + goodsName + "   【商品价格：】" + goodsPrice + "    【商品详情：】" + goodsContent;
		String name =  "qr"+UUID.randomUUID()+".jpg";
		String fileName =  filePath+ name;
		
		QRCodeUtils.createORcode(qrData, fileName);
		goods.setQrcode(name);
		boolean flag = goodsService.addProduce(goods);
		if(flag == true){
			ret.setResult(200);
		}else{
			ret.setResult(500);
		}
		return ret;
	}
	
	@RequestMapping(value="/selGoodsLimit",method=RequestMethod.GET)
	public ReturnInfo<List<Goods>> selGoodsLimit(){
		ReturnInfo<List<Goods>> ret = new ReturnInfo<List<Goods>>();
		List<Goods> list = goodsService.selGoodsLimit();
		if(list != null){
			ret.setData(list);
			ret.setResult(200);
		}
		return ret;
	}
	
	@RequestMapping(value="/selGoods",method=RequestMethod.GET)
	public ReturnInfo<List<Goods>> selGoods(){
		ReturnInfo<List<Goods>> ret = new ReturnInfo<List<Goods>>();
		List<Goods> list = goodsService.selGoods();
		if(list != null){
			ret.setData(list);
			ret.setResult(200);
		}
		return ret;
	}
	@RequestMapping(value="/selGoodsBusiness",method=RequestMethod.GET)
	public ReturnInfo<List<Goods>> selGoodsBusiness(HttpServletRequest request){
		ReturnInfo<List<Goods>> ret = new ReturnInfo<List<Goods>>();
		List<Goods> list = goodsService.selGoodsBusiness(request.getSession().getAttribute("businessname").toString());
		if(list != null){
			ret.setData(list);
			ret.setResult(200);
		}
		return ret;
	}
	
	/*分页查询商品信息*/
	@RequestMapping(value="/datagrid",method=RequestMethod.POST)
    public ReturnInfo<PageInfo<Goods>> dataGrid(String goodName, String categoryType, Integer pageNumber, Integer pageSize){
        ReturnInfo<PageInfo<Goods>> ret = new ReturnInfo<PageInfo<Goods>>();
        PageInfo<Goods> pageData = goodsService.dataGrid(goodName,categoryType, pageNumber, pageSize);
        if(pageData.getList() != null){
            ret.setData(pageData);
            ret.setResult(200);
        }
        return ret;
    }
	
	/*分页查询商品信息*/
    @RequestMapping(value="/findbyid",method=RequestMethod.GET)
    public ReturnInfo<Goods> findById(String productId){
        ReturnInfo<Goods> ret = new ReturnInfo<Goods>();
        Goods pageData = goodsService.findById(productId);
        if(pageData != null){
            ret.setData(pageData);
            ret.setResult(200);
        }
        return ret;
    }
}
