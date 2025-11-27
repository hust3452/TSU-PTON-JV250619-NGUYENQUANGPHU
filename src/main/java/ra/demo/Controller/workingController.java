package ra.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.demo.DTO.workingDTO;
import ra.demo.Model.working;
import ra.demo.Service.workingService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/working")
public class workingController {
    @Autowired
    private workingService workingService;

//    @GetMapping
//    public String working(
//            @RequestParam(defaultValue = "1") int page,
//            @RequestParam(defaultValue = "5") int size,
//            @RequestParam(defaultValue = "") String searchName,
//            Model model
//            ) {
//        List<working> workings = workingService.findAll(page,size,searchName);
//        long totalElement = workingService.countTotalElement(searchName);
//        int totalPages = (int) Math.ceil((double) totalElement/size);
//        List<Integer> pages = new ArrayList<Integer>();
//
//        for (int i = 1; i <= totalPages; i++) {
//            pages.add(i);
//        }
//        model.addAttribute("page", page);
//        model.addAttribute("pages", pages);
//        model.addAttribute("totalElement", totalElement);
//        model.addAttribute("searchName", searchName);
//        model.addAttribute("workings", workings);
//        model.addAttribute("size", size);
//        return "WorkingHome";
//    }

    @GetMapping
    public String findAllWorking(Model model) {
        List<working> workings = workingService.findAll();
        model.addAttribute("workings", workings);
        return "WorkingHome";
    }


    @GetMapping("/initCreate")
    public String initCreate(Model model) {
        model.addAttribute("workingDTO", new workingDTO());
        return "WorkingAdd";
    }

    @PostMapping("/create")
    public String createWorking(@Valid @ModelAttribute("workingDTO") workingDTO workingDTO, BindingResult bindingResult,
                                Model model) {
        if(workingDTO.getWorkingImage()==null||workingDTO.getWorkingImage().isEmpty()){
            bindingResult.rejectValue("workingImage", "error.image.empty","Image can not empty");
        }

        if (bindingResult.hasErrors()) {
            return "WorkingAdd";
        }
        boolean result = workingService.add(workingDTO);
        if (result) {
            return "redirect:/working";
        }
        return "Error";
    }

    @GetMapping("/delete/{id}")
    public String deleteWorking(Model model, @PathVariable("id") int id) {
        try {
            boolean result = workingService.deleteById(id);
            if (result) {
                return "redirect:/working";
            } else {
                return "Error";
            }
        } catch (Exception e) {
            return "Error";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        working working = workingService.findById(id);
        model.addAttribute("editWorkingDTO", working);
        return "WorkingEdit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, @Valid @ModelAttribute("editWorkingDTO") workingDTO workingDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "WorkingEdit";
        }
        boolean newWorking = workingService.EditById(workingDTO, id);
        if (newWorking) {
            return "redirect:/working";
        } else {
            model.addAttribute("editWorkingDTO", workingDTO);
            return "Error";
        }
    }
}
