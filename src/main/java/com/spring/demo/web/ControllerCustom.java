package com.spring.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.demo.pojo.Pepole;

/**
 * 自定义properties 常量内容获取示例
 * @author HuangKai
 */
@Controller
@RequestMapping("custom")
public class ControllerCustom extends ControllerBase {

	//使用@Value 注解，获取application-custom.properties 中定义的常量数据
	@Value("${custom.name}")
	String custom_name;
	
	//自动映射成list
	@Value("#{'${custom.list}'.split(',')}")
	private List<String> list = new ArrayList<String>();
	
	@RequestMapping(value = "name")
	@ResponseBody
	public Object name() {
	    return custom_name;
	}
	
	@RequestMapping(value = "list")
	@ResponseBody
	public Object list() {
	    return list;
	}
	
	@RequestMapping(value = "index/{id}")
	public ModelAndView index(@PathVariable int id,ModelAndView mav) {
		mav.addObject("id", id);
		mav.setViewName("index");
	    return mav;
	}
	
	@RequestMapping(value = "pojo")
	@ResponseBody
	public Object pojo(@RequestAttribute Pepole pepole) {
	    return pepole.toString();
	}
	
	/**
	 * json类型的数据绑定
	 * ajax提交数据时 Content-Type:application/json;charset=UTF-8
	 * @param pepole ：{"name":"sam","age":32}
	 * @return
	 */
	@RequestMapping(value = "pojo2")
	@ResponseBody
	public Object pojo2(@RequestBody Pepole pepole) {
	    return pepole.toString();
	}
	
	/**
	 * get请求URL（?name=sam&age=32）可以<br>
	 * or<br>
	 * form表单提交 Content-Type:application/x-www-form-urlencoded<br>
	 * @param pepole ： name=sam&age=32
	 * @return
	 */
	@RequestMapping(value = "pojo3")
	@ResponseBody
	public Object pojo3(Pepole pepole) {
	    return pepole.toString();
	}
	
	/**
	 * get or Post（localhost:8090/custom/pojo4?name=sam&age=32）url地址里 都可以,不可以放在body里。<br>
	 * 或者 <br>
	 * form表单提交 Content-Type:application/x-www-form-urlencoded ,可以放在body里面<br>
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping(value = "pojo4")
	@ResponseBody
	public Object pojo4(@RequestParam("name")String name,@RequestParam("age")int age) {
	    return name+" , "+age;
	}
	
	/**
	 * 参数在url中
	 * @param Pepole
	 * @return
	 */
	@RequestMapping(value = "pojo5/name/{name}/age/{age}")
	@ResponseBody
	public Object pojo5(@ModelAttribute Pepole pepole) {
	    return pepole;
	}
	
	/**
	 * 与 pojo3方法 一样可以没有"@ModelAttribute"
	 * GET:http://localhost:8090/custom/pojo6?name=sam&age=32<br>
	 * POST:http://localhost:8090/custom/pojo6   BODY: name=sam&age=32   Content-Type:application/x-www-form-urlencoded<br>
	 * @param Pepole
	 * @return
	 */
	@RequestMapping(value = "pojo6")
	@ResponseBody
	public Object pojo6(@ModelAttribute Pepole pepole) {
	    return pepole;
	}
	
}
