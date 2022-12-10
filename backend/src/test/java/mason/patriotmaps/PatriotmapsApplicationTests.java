package mason.patriotmaps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mason.patriotmaps.entity.BuildingEntity;
import mason.patriotmaps.entity.ClassEntity;
import mason.patriotmaps.entity.UserEntity;
import mason.patriotmaps.repository.BuildingRepository;
import mason.patriotmaps.repository.ClassRepository;
import mason.patriotmaps.repository.UserRepository;
import net.bytebuddy.build.ToStringPlugin;
import org.apache.catalina.connector.Response;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;


import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
class PatriotmapsApplicationTests {

	@Autowired
	BuildingRepository buildingRepository;
	@Autowired
	ClassRepository classRepository;
	@Autowired
	UserRepository userRepository;

	/**
	 * Building Entity Tests
	 */
	@Test
	public void setBuildingID(){
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setBuilding_id(1);
		assertThat(1).isEqualTo(buildingEntity.getBuilding_id());
	}

	@Test
	public void longitude(){
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setLongitude(123);
		assertThat(123).isEqualTo(buildingEntity.getLongitude());
	}

	@Test
	public void latitude(){
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setLatitude(0);
		assertThat(0).isEqualTo(buildingEntity.getLatitude());
	}

	/**
	 * Class entity tests
	 */
	@Test
	public void class_id(){
		ClassEntity classEntity = new ClassEntity();
		classEntity.setClass_id(0);
		assertThat(0).isEqualTo(classEntity.getClass_id());
	}

	@Test
	public void class_name(){
		ClassEntity classEntity = new ClassEntity();
		classEntity.setClass_name("CS321");
		assertThat("CS321").isEqualTo(classEntity.getClass_name());
	}


	@Test
	public void class_weekdays(){
		ClassEntity classEntity = new ClassEntity();
		classEntity.setWeek_days("Monday");
		assertThat("Monday").isEqualTo(classEntity.getWeek_days());
	}


	@Test
	public void class_buildingid(){
		ClassEntity classEntity = new ClassEntity();
		classEntity.setBuilding_id(0);
		assertThat(0).isEqualTo(classEntity.getBuilding_id());
	}

	@Test
	public void class_time(){
		ClassEntity classEntity = new ClassEntity();
		classEntity.setTime("10:30");
		assertThat("10:30").isEqualTo(classEntity.getTime());
	}

	@Test
	public void class_notes(){
		ClassEntity classEntity = new ClassEntity();
		classEntity.setNotes("I need to get to this class by 10:30");
		assertThat("I need to get to this class by 10:30").isEqualTo(classEntity.getNotes());
	}

	@Test
	public void class_prof(){
		ClassEntity classEntity = new ClassEntity();
		classEntity.setProf("Dr. Wassim Masri");
		assertThat("Dr. Wassim Masri").isEqualTo(classEntity.getProf());
	}

	/**
	 * Tests for User Entity
	 */
	@Test
	public void user_id(){
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(3);
		assertThat(3).isEqualTo(userEntity.getUserId());
	}

	@Test
	public void user_username(){
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername("Andrew");
		assertThat("Andrew").isEqualTo(userEntity.getUsername());
	}

	@Test
	public void user_password(){
		UserEntity userEntity = new UserEntity();
		userEntity.setPassword("secret password");
		assertThat("secret password").isEqualTo(userEntity.getPassword());
	}

	@Test
	public void user_addClass(){
		UserEntity userEntity = new UserEntity();
		ArrayList<Integer> classes = new ArrayList<>();
		classes.add(1);
		userEntity.addClass(1);
		assertThat(classes).isEqualTo(userEntity.getClass_list());
	}

	@Test
	public void user_addClass2(){
		UserEntity userEntity = new UserEntity();
		ArrayList<Integer> classes = new ArrayList<>();
		classes.add(1);
		classes.add(2);
		classes.add(Integer.MAX_VALUE);
		classes.add(Integer.MIN_VALUE);
		userEntity.addClass(1);
		userEntity.addClass(2);
		userEntity.addClass(Integer.MAX_VALUE);
		userEntity.addClass(Integer.MIN_VALUE);
		assertThat(classes).isEqualTo(userEntity.getClass_list());
	}

	@Test
	public void user_removeClass(){
		UserEntity userEntity = new UserEntity();
		ArrayList<Integer> classes = new ArrayList<>();
		userEntity.addClass(1);
		userEntity.removeClass(1);
		assertThat(classes).isEqualTo(userEntity.getClass_list());
	}

	@Test
	public void user_removeClass2(){
		UserEntity userEntity = new UserEntity();
		ArrayList<Integer> classes = new ArrayList<>();
		userEntity.addClass(1);
		userEntity.addClass(Integer.MIN_VALUE);
		userEntity.addClass(Integer.MAX_VALUE);
		userEntity.removeClass(1);
		userEntity.removeClass(Integer.MAX_VALUE);
		userEntity.removeClass(Integer.MIN_VALUE);
		assertThat(classes).isEqualTo(userEntity.getClass_list());
	}

	/**
	 * User repository tests
	 */
	@Test
	public void userRepository_getRecord0(){
		UserEntity user = new UserEntity();
		UserEntity fromRepo;
		user.setUsername("userRepository_getRecord");
		user.setPassword("test0");
		userRepository.save(user);
		fromRepo = userRepository.findByUsername(user.getUsername());
		assertThat(user.getUsername()).isEqualTo(fromRepo.getUsername());
		assertThat(user.getPassword()).isEqualTo(fromRepo.getPassword());
	}

	@Test
	public void userRepository_getRecord1(){
		UserEntity user = new UserEntity();
		UserEntity fromRepo;
		user.setUsername("userRepository_getRecord1");
		user.setPassword("test1");
		userRepository.save(user);
		fromRepo = userRepository.findByUsername(user.getUsername());
		assertThat(user.getUsername()).isEqualTo(fromRepo.getUsername());
		assertThat(user.getPassword()).isEqualTo(fromRepo.getPassword());
	}

	@Test
	public void userRepository_getRecord2(){
		Optional<UserEntity> user = userRepository.findById(-1l);
		assertThat(user).isEqualTo(Optional.empty());
	}
}
