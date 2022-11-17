package mason.patriotmaps.controller;
import mason.patriotmaps.entity.BuildingEntity;
import mason.patriotmaps.entity.ClassEntity;
import mason.patriotmaps.entity.UserEntity;
import mason.patriotmaps.repository.BuildingRepository;
import mason.patriotmaps.repository.ClassRepository;
import mason.patriotmaps.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/methods")
public class MethodsController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BuildingRepository buildingRepository;
    @Autowired
    ClassRepository classRepository;


    /**
     * Returns the users list of classes, or else it returns an empty ArrayList.
     * @return list of classes from the database
     */
    @GetMapping("/getClasses")
    @ResponseBody
    //first get the primary key of the class entity and then return all the classes.
    public List<String> getClassNames(){
        String username = ((UserDetails)(SecurityContextHolder.getContext().getAuthentication().getPrincipal())).getUsername();
        Collection<Integer> classes = userRepository.findByUsername(username).getClass_list();
        List<String> classesAsString = new ArrayList<>();
        if(classes != null)
            for(Integer ID : classes) {
                Optional<ClassEntity> currentClass = classRepository.findById(new Long(ID));
                if(currentClass.isPresent()){
                    ClassEntity classEntity = currentClass.get();
                    classesAsString.add(Long.toString(classEntity.getClass_id()));
                    classesAsString.add(classEntity.getClass_name());
                    classesAsString.add(Integer.toString(classEntity.getWeek_days()));
                    classesAsString.add(Integer.toString(classEntity.getBuilding_id()));
                    classesAsString.add(classEntity.getTime());
                    classesAsString.add(classEntity.getNotes());
                    classesAsString.add(classEntity.getColor());
                    classesAsString.add(classEntity.getProf());
                }
            }
        if(classesAsString.isEmpty()) classesAsString.add("no classes found!");
        return classesAsString;
    }

    /**
     * method to submit a class for the user
     *
     *
     */
    @PostMapping("/addClass")
    public String addClass(@ModelAttribute ClassEntity toBeAdded){
        String username = ((UserDetails)(SecurityContextHolder.getContext().getAuthentication().getPrincipal())).getUsername();
        classRepository.save(toBeAdded);
        UserEntity user = userRepository.findByUsername(username);
        user.addClass(Math.toIntExact(toBeAdded.getClass_id()));
        userRepository.save(user);
        return "redirect:/homepage";
    }

    /**
     * To use this method you will have to pass the primary
     * Key of the class table.
     * @param id the primary key of the classEntity
     */
    @PostMapping("/deleteClass")
    public String removeClass(@RequestParam int id){
        String username = ((UserDetails)(SecurityContextHolder.getContext().getAuthentication().getPrincipal())).getUsername();
        ClassEntity classToBeRemoved = classRepository.findById(new Long(id)).get();
        userRepository.findByUsername(username).removeClass(id);
        classRepository.delete(classToBeRemoved);
        return "redirect:/homepage";
    }

    /**
     * Given the id of the building, this function returns
     * the latitude and longitude of the building
     * @param buildingID primary key
     * @return latitude and longitude in this order.
     */
    @GetMapping("/getCoordinates")
    @ResponseBody
    public long[] buildingCoordinates(long buildingID){
        Optional<BuildingEntity> building = buildingRepository.findById(buildingID);
        long[] coordinates = new long[2];
        if(building.isEmpty()) return coordinates;
        coordinates[0] = buildingRepository.findById(buildingID).get().getLatitude();
        coordinates[1] = buildingRepository.findById(buildingID).get().getLongitude();
        return coordinates;
    }

    @PostMapping("/setdaysoftheweek")
    public void daysOfTheWeek(int dayOfTheWeekCode){

    }

    /**
     * to use this method you must provide the username
     * and new password
     * @param password new Password
     */
    @PostMapping("/resetPassword")
    public void changePassword(String password){
        String username = ((UserDetails)(SecurityContextHolder.getContext().getAuthentication().getPrincipal())).getUsername();
        UserEntity user = userRepository.findByUsername(username);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

    @GetMapping("/get_building_aka")
    @ResponseBody
    public List<String> getBuildingAKAS(long id){
        Optional<BuildingEntity> building = buildingRepository.findById(id);
        List<String> akas = new ArrayList<>();
        if(building.isPresent()) akas = (ArrayList<String>) building.get().getAkas();
        return akas;
    }
    //signout method.
    //to delete class, they are gonna use the name of the class.
    //return the days of the week

    //individual setters for the class object.
    //have a method that returns all the akas of all the buildings
    //change password, and logout
}
