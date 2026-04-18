package org.eclipse.che.ide.ui.smartTree;

import java.util.Comparator;


public enum SortDir {
  
  ASC {
    @Override
    public <X> Comparator<X> comparator(final Comparator<X> c) {
      return new Comparator<X>() {
        public int compare(X o1, X o2) {
          return c.compare(o1, o2);
        }
      };
    }
  },

  
  DESC {
    @Override
    public <X> Comparator<X> comparator(final Comparator<X> c) {
      return new Comparator<X>() {
        public int compare(X o1, X o2) {
          return c.compare(o2, o1);
        }
      };
    }
  };

  
  public static SortDir toggle(SortDir sortDir) {
    return (sortDir == ASC) ? DESC : ASC;
  }

  
  public abstract <X> Comparator<X> comparator(Comparator<X> c);
}