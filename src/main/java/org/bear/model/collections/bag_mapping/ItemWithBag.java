package org.bear.model.collections.bag_mapping;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "item_bag_mapping")
public class ItemWithBag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ElementCollection
	@CollectionTable(name = "image_bag_mapping")
	@Column(name = "filename")
	@SequenceGenerator(name = "image_gen", sequenceName = "image_seq", allocationSize = 1)
	@CollectionId(
			columns = @Column(name = "image_id"),
			type = @org.hibernate.annotations.Type(type = "long"),
			generator = "image_gen"
	)
	private Collection<String> images = new ArrayList<>();
}
