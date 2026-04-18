package org.springframework.hateoas.mediatype;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jspecify.annotations.NonNull;
import org.springframework.hateoas.AffordanceModel.InputPayloadMetadata;
import org.springframework.hateoas.AffordanceModel.Named;
import org.springframework.hateoas.AffordanceModel.PropertyMetadata;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;


class TypeBasedPayloadMetadata implements InputPayloadMetadata {

	private final Class<?> type;
	private final SortedMap<String, PropertyMetadata> properties;
	private final List<MediaType> mediaTypes;

	TypeBasedPayloadMetadata(Class<?> type, Stream<PropertyMetadata> properties) {
		this(type, new TreeMap<>(
				properties.collect(Collectors.toMap(PropertyMetadata::getName, Function.identity()))), Collections.emptyList());
	}

	TypeBasedPayloadMetadata(Class<?> type, SortedMap<String, PropertyMetadata> properties,
			List<MediaType> mediaTypes) {

		Assert.notNull(type, "Type must not be null!");
		Assert.notNull(properties, "Properties must not be null!");
		Assert.notNull(mediaTypes, "Media types must not be null!");

		this.type = type;
		this.properties = properties;
		this.mediaTypes = mediaTypes;
	}

	
	@Override
	public <T extends Named> T customize(T target, Function<PropertyMetadata, T> customizer) {

		PropertyMetadata metadata = this.properties.get(target.getName());

		return metadata == null ? target : customizer.apply(metadata);
	}

	
	@Override
	public Stream<PropertyMetadata> stream() {
		return properties.values().stream();
	}

	
	@Override
	public List<String> getI18nCodes() {
		return Arrays.asList(type.getName(), type.getSimpleName());
	}

	
	@NonNull
	public Class<?> getType() {
		return this.type;
	}

	
	@Override
	public InputPayloadMetadata withMediaTypes(List<MediaType> mediaTypes) {
		return new TypeBasedPayloadMetadata(type, properties, mediaTypes);
	}

	
	@Override
	public List<MediaType> getMediaTypes() {
		return mediaTypes;
	}

	
	@Override
	public boolean equals(Object obj) {

		if (obj == this) {
			return true;
		}

		if (!(obj instanceof TypeBasedPayloadMetadata)) {
			return false;
		}

		TypeBasedPayloadMetadata that = (TypeBasedPayloadMetadata) obj;

		return this.type.equals(that.type)
				&& this.properties.equals(that.properties)
				&& this.mediaTypes.equals(that.mediaTypes);
	}

	
	@Override
	public int hashCode() {

		int result = 31;

		result += 17 * type.hashCode();
		result += 17 * properties.hashCode();
		result += 17 * mediaTypes.hashCode();

		return result;
	}
}