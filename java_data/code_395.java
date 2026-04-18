package io.jenetics.util;

import static java.util.Objects.requireNonNull;

import java.util.Comparator;
import java.util.function.Supplier;


public final class Ordered<T> implements Comparable<Ordered<T>>, Supplier<T> {
	private final T _value;
	private final Comparator<? super T> _comparator;

	private Ordered(final T value, final Comparator<? super T> comparator) {
		_value = value;
		_comparator = requireNonNull(comparator);
	}

	
	@Override
	public T get() {
		return _value;
	}

	@Override
	public int compareTo(final Ordered<T> other) {
		return _comparator.compare(_value, other._value);
	}

	
	public static <T> Ordered<T> of(
		final T value,
		final Comparator<? super T> comparator
	) {
		return new Ordered<>(value, comparator);
	}

}