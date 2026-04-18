package preibisch_imagelib2.algorithm.componenttree;

import java.util.List;

import preibisch_imagelib2.Localizable;


public interface Component< T, C extends Component< T, C > > extends Iterable< Localizable >
{
	
	public long size();

	
	public T value();

	
	public C getParent();

	
	public List< C > getChildren();
}