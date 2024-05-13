package org.example.elasticsearchservice.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;
@Data
@Document( indexName = "hotel-index")
public class Hotel {

    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Text)
    private String address;
    @Field(type = FieldType.Keyword)
    private String brand;
    @Field(type = FieldType.Text)
    private String city;
    @Field(type = FieldType.Text)
    private String rating;
    @Field(type = FieldType.Text)
    private String district;
    @Field(type = FieldType.Text)
    private String latitude;
    @Field(type = FieldType.Text)
    private String longitude;
    @Field(type = FieldType.Text)
    private String imageURL;
    @Field(type = FieldType.Keyword)
    private List <String> tags;
}
