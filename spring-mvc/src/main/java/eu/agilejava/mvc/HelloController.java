/*
 * The MIT License
 *
 * Copyright 2015 Ivar Grimstad (ivar.grimstad@gmail.com).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package eu.agilejava.mvc;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.servlet.ModelAndView;

/**
 * Simple Hello controller for Spring MVC.
 * @author Ivar Grimstad (ivar.grimstad@gmail.com)
 */
@Controller
public class HelloController {

   @Autowired
   private Validator validator;

   @RequestMapping(value = "hello")
   public ModelAndView helloWorld() {

      Map<String, Object> helloModel = new HashMap<>();

      ModelAndView mv = new ModelAndView("form", helloModel);

      return mv;
   }

   @RequestMapping(value = "hello", method = POST)
   public ModelAndView formPost(@ModelAttribute("form") @Validated HelloBean form, BindingResult bindingResult) {

      if (bindingResult.hasErrors()) {

         Map<String, Object> errorModel = new HashMap<>();
         ObjectError error = bindingResult.getAllErrors().iterator().next();
         errorModel.put("property", ((FieldError) error).getField());
         errorModel.put("value", ((FieldError) error).getRejectedValue());
         errorModel.put("message", error.getDefaultMessage());

         ModelAndView mv = new ModelAndView("form", errorModel);

         return mv;
      }

      Map<String, Object> helloModel = new HashMap<>();
      helloModel.put("name", form.getFirstName() + " " + form.getLastName());

      ModelAndView mv = new ModelAndView("hello", helloModel);

      return mv;
//      if (validationResult.isFailed()) {
//         final Set<ConstraintViolation<?>> set = validationResult.getAllViolations();
//         final ConstraintViolation<?> cv = set.iterator().next();
//         final String property = cv.getPropertyPath().toString();
//
//         models.put("property", property.substring(property.lastIndexOf('.') + 1));
//         models.put("value", cv.getInvalidValue());
//         models.put("message", cv.getMessage());
//
//         return Response.status(BAD_REQUEST).entity("error.jsp").build();
   }
}
