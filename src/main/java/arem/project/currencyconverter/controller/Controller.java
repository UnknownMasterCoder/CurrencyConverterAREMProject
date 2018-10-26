package arem.project.currencyconverter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//import arem.project.currencyconverter.impl.ConverterBP;
import arem.project.currencyconverter.impl.Converter;
import arem.project.currencyconverter.model.Exchange;
import arem.project.currencyconverter.model.Result;

@RestController
public class Controller {

    @Autowired
    Converter converter;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/currencyconverter", method = RequestMethod.GET)
    public ModelAndView currencyconverter(ModelAndView mnv) {
        mnv.setViewName("currencyconverter");
        mnv.addObject("exchange", converter.getConverterExchange());
        return mnv;
    }
    
    @RequestMapping(value = "/convert", method = RequestMethod.POST)
    public ResponseEntity<Result> doConvert(@ModelAttribute Exchange cModel, Model model, HttpServletRequest request) {
        HttpStatus status = HttpStatus.OK;
        model.addAttribute("exchange", cModel);
        Result rm = converter.getConvertedValue(cModel.getActualCurrency(), cModel.getWantedCurrency(), cModel.getActualAmount());
        return new ResponseEntity<Result>(rm, status);
    }
    

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView about() {
        return new ModelAndView("about");
    }
}
