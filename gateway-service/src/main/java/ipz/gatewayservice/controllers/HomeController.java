package ipz.gatewayservice.controllers;


import ipz.gatewayservice.models.Doctor;
import ipz.gatewayservice.models.Patient;
import ipz.gatewayservice.repositories.IBranchRepository;
import ipz.gatewayservice.repositories.IDoctorRepository;
import ipz.gatewayservice.repositories.IOfficeRepository;
import ipz.gatewayservice.repositories.IPatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    Logger logger = LoggerFactory.getLogger("Login success handler: ");

    @Autowired
    IDoctorRepository iDoctorRepository;
    @Autowired
    IPatientRepository iPatientRepository;
    @Autowired
    IBranchRepository iBranchRepository;
    @Autowired
    IOfficeRepository iOfficeRepository;
//    @GetMapping("jwt")
//    public OAuth2AccessToken jwt(OAuth2AuthenticationToken authentication) {
//        OAuth2AuthorizedClient client =
//                oAuth2AuthorizedClientService.loadAuthorizedClient(authentication.getAuthorizedClientRegistrationId(), authentication.getName());
//
//        return client.getAccessToken();
//    }

    private static String decode(String encodedString) {
        return new String(Base64.getUrlDecoder().decode(encodedString));
    }

    private String prettyPrintAttributes(Map<String, Object> attributes) {
        String acc = "User Attributes: <br/><div style='padding-left:20px'>";
        for (String key : attributes.keySet()){
            Object value = attributes.get(key);
            acc += "<div>"+key + ":&nbsp" + value.toString() + "</div>";
        }
        return acc + "</div>";
    }

//    @RequestMapping("whoami")
//    @ResponseBody
//    public Map<String, String> whoami(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
//                         @AuthenticationPrincipal OAuth2User oauth2User) throws JSONException {
//        String[] chunks = authorizedClient.getAccessToken().getTokenValue().split("\\.");
//        JSONObject payload = new JSONObject(((decode(chunks[1]))));
//        var attributes = oauth2User.getAttributes();
//
//        HashMap<String, String> map = new HashMap<>();
//
//        if(payload.getString("Groups").contains("Doctors")) {
//            Doctor doctor = iDoctorRepository.findDoctorByOktaUID((String) attributes.get("sub"));
//            map.put("id", doctor.getId().toString());
//            map.put("last_name", doctor.getLastName());
//            map.put("name", doctor.getName());
//            map.put("oktauid", doctor.getOktaUID());
//            map.put("branch_id", doctor.getBranch().toString());
//        }
//
//        if(payload.getString("Groups").contains("Patients")) {
//            Patient patient = iPatientRepository.findPatientByOktaUID((String) attributes.get("sub"));
//            map.put("id", patient.getId().toString());
//            map.put("last_name", patient.getLastName());
//            map.put("name", patient.getName());
//            map.put("oktauid", patient.getOktaUID());
//        }
//
//        return map;
//    }

//    @RequestMapping(value = "whoami")
//    @ResponseBody
//    public Map<String, Object> whoami(@AuthenticationPrincipal OAuth2User oauth2User) {
//        var attributes = oauth2User.getAttributes();
//        return attributes;
//    }

    @GetMapping("whoami")
    @ResponseBody
    public Map<String, Object> whoami(@AuthenticationPrincipal Jwt jwt) {
        Map<String, Object> map = jwt.getClaims();
        HashMap<String, Object> res = new HashMap<>();
        res.put("oktauid", map.get("uid").toString());
        res.put("sub", map.get("sub").toString());
        res.put("Groups", map.get("Groups").toString());

        if(map.get("Groups").toString().contains("Patients")) {
            Patient patient = iPatientRepository.findPatientByOktaUID(map.get("uid").toString());
            res.put("name", patient.getName());
            res.put("last_name", patient.getLastName());
            res.put("id", patient.getId().toString());
        }
        if(map.get("Groups").toString().contains("Doctors")) {
            Doctor doctor = iDoctorRepository.findDoctorByOktaUID(map.get("uid").toString());
            res.put("name", doctor.getName());
            res.put("last_name", doctor.getLastName());
            res.put("branch", doctor.getBranch().getId().toString());
            res.put("id", doctor.getId().toString());
        }
        return res;
    }

    @RequestMapping("")
    @ResponseBody
    public String oauthUserInfo(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
                                @AuthenticationPrincipal OAuth2User oauth2User) throws JSONException {
        String[] chunks = authorizedClient.getAccessToken().getTokenValue().split("\\.");
        JSONObject header = new JSONObject(((decode(chunks[0]))));
        JSONObject payload = new JSONObject(((decode(chunks[1]))));
        var attributes = oauth2User.getAttributes();

        if(payload.getString("Groups").contains("Doctors")) {
//            logger.info((String) attributes.get("given_name"));
//            logger.info((String) attributes.get("family_name"));
//            logger.info((String) attributes.get("sub"));
            Doctor doc = iDoctorRepository.findDoctorByOktaUID((String) attributes.get("sub"));
            if(doc == null) {
                iDoctorRepository.save(new Doctor(
                        (String) attributes.get("given_name"),
                        (String) attributes.get("family_name"),
                        (String) attributes.get("sub"),
                        iBranchRepository.findById(1L).get(),
                        iOfficeRepository.findById(1L).get()
                        )
                );
            }
        }

        if(payload.getString("Groups").contains("Patients")) {
//            logger.info((String) attributes.get("given_name"));
//            logger.info((String) attributes.get("family_name"));
//            logger.info((String) attributes.get("sub"));
            Patient patient = iPatientRepository.findPatientByOktaUID((String) attributes.get("sub"));
            if(patient == null) {
                iPatientRepository.save(new Patient(
                                (String) attributes.get("given_name"),
                                (String) attributes.get("family_name"),
                                (String) attributes.get("sub")
                        )
                );
            }
        }

        return
                "Token: " + authorizedClient.getAccessToken().getTokenValue() + "<br/>" +
                "User Name: " + oauth2User.getName() + "<br/>" +
                "User Authorities: " + oauth2User.getAuthorities() + "<br/>" +
                "Client Name: " + authorizedClient.getClientRegistration().getClientName() + "<br/>" +
                        "Header: " + header + "<br/>" +
                        "Payload: " + payload + "<br/>" +
                        this.prettyPrintAttributes(oauth2User.getAttributes());
    }
}
