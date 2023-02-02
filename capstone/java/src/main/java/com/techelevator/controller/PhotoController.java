package com.techelevator.controller;

import java.util.List;

import com.techelevator.dao.PhotoDao;
import com.techelevator.model.Photo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")

@RequestMapping("/photo")
public class PhotoController {
    private PhotoDao photoDao;

    public PhotoController(PhotoDao photoDao) {
        this.photoDao = photoDao;
    }

    @RequestMapping(value = "/band/{bandId}", method = RequestMethod.GET)
    public List<Photo> findPhotoByBandId(@PathVariable int bandId) {
        return photoDao.findPhotoByBandId(bandId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addPhoto(@RequestBody Photo photo) {
        photoDao.addPhoto(photo);
    }

    @RequestMapping(value = "/delete/{photoId}", method = RequestMethod.DELETE)
    public void deletePhoto(@PathVariable int photoId) {
        Photo photo = new Photo();
        photo.setPhotoId(photoId);
        photoDao.deletePhoto(photo);
    }
}
