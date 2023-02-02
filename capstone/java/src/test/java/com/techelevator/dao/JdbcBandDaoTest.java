package com.techelevator.dao;

import com.techelevator.model.Band;
import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JdbcBandDaoTest extends BaseDaoTests {
    protected static final Band BAND_1 = new Band(1, "band1", "band", "img", 1);
    protected static final Band BAND_2 = new Band(2, "band2", "band", "img", 2);

    private JdbcBandDao sut;

    @Test
    public void find_All_Bands() {
        List<Band> band = sut.findAll();
        Assert.assertNotNull(band);
        Assert.assertEquals(2, band.size());
        Assert.assertEquals(BAND_1, band.get(0));
        Assert.assertEquals(BAND_2, band.get(1));
    }

    @Test
    public void get_Band_ById() {

    }

    @Test
    public void find_By_Band_Name() {
    }

    @Test
    public void find_Id_By_Band_Name() {
    }

    @Test
    public void find_Genre_For_Band() {
    }

    @Test
    public void add_Band_To_User() {
    }

    @Test
    public void create_Band() {
        Band newBand = new Band(-1, "newBand", "band", "img", 1);

       int bandWasCreated = sut.create(newBand);

        ;
    }
}