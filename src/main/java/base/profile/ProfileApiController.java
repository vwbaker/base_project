package base.profile;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/profile/{id}")
public class ProfileApiController {
  @Autowired
  private ProfileRepository profileRepository;

  @GetMapping
  public ArrayList<Profile> listAll() {
    ArrayList<Profile> profiles = new ArrayList<>();
    profileRepository.findAll().forEach(profile -> profiles.add(profile));
    return profiles;
  }

  @GetMapping("{id}")
  public Profile find(@PathVariable Long id) {
    return profileRepository.findOne(id);
  }

  @PostMapping
  public Profile create(@RequestBody Profile input) {
    return profileRepository
        .save(new Profile(input.getFirstName(), input.getLastName(), input.getEmail()));
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable Long id) {
    profileRepository.delete(id);
  }

  @PutMapping("{id}")
  public Profile update(@PathVariable Long id, @RequestBody Profile input) {
    Profile profile = profileRepository.findOne(id);
    if (profile == null) {
      return null;
    } else {
      profile.setFirstName(input.getFirstName());
      profile.setLastName(input.getLastName());
      profile.setEmail(input.getEmail());
      return profileRepository.save(profile);
    }
  }
}
