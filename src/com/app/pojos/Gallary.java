/*
 * package com.app.pojos;
 * 
 * import java.util.ArrayList;
 * 
 * import java.util.List;
 * 
 * 
 * import javax.persistence.*;
 * 
 * @Entity
 * 
 * @Table(name = "gallary") public class Gallary { private Integer id; private
 * List<Image> images = new ArrayList<>(); private Photographer photographer;
 * 
 * public Gallary() { System.out.println("in gallary constr"); }
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * 
 * @Column(name = "g_id") public Integer getId() { return id; }
 * 
 * public void setId(Integer id) { this.id = id; }
 * 
 * 
 * @OneToMany(mappedBy = "gallary",cascade=CascadeType.ALL,orphanRemoval=true)
 * public List<Image> getImages() { return images; }
 * 
 * 
 * public void setImages(List<Image> images) { this.images = images; }
 * 
 * @OneToOne
 * 
 * @JoinColumn(name = "photogr_id") public Photographer getPhotographer() {
 * return photographer; }
 * 
 * public void setPhotographer(Photographer photographer) { this.photographer =
 * photographer; }
 * 
 * public void addImage(Image image) { image.setGallary(this);
 * images.add(image); }
 * 
 * public void removeImage(Image image) { image.setGallary(null);
 * images.remove(image); } }
 */