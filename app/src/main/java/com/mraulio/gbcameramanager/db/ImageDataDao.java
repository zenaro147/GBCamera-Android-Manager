package com.mraulio.gbcameramanager.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.mraulio.gbcameramanager.model.GbcImage;
import com.mraulio.gbcameramanager.model.ImageData;

import java.util.List;

/**
 *  La anotación @Transaction en el DAO indica que la operación de inserción de una imagen con sus datos de imagen correspondientes se realizará en una transacción para garantizar la integridad de los datos.
 */
@Dao
public interface ImageDataDao {
    @Query("SELECT * FROM image_data")
    List<ImageData> getAll();

    @Query("SELECT data FROM image_data WHERE image_id = :imageId")
    byte[] getDataByImageId(String imageId);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ImageData imageData);

    @Delete
    void delete(ImageData imageData);
}