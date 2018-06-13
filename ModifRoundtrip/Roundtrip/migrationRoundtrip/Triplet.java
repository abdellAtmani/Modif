package migrationRoundtrip;

import java.util.*;

/**
 * Subset of the cartesian product of three sets U, V and W. This subset is organised as a double map from U to a map from V to W.
 * @param <U> First component (key 1)
 * @param <V> Second component (key 2)
 * @param <W> Third component (values)
 * @author M. Kerboeuf
 */
class Triplet<U, V, W> {
	private Map<U, Map<V, Collection<W>>> map;

	/**
	 * Creates and empty subset.
	 */
	public Triplet() {
		this.map = new HashMap<U, Map<V, Collection<W>>>();
	}
	
	/**
	 * Provides a <b>copy</b> of the collection of values from the third component W
	 * associated to a given value of the first component U and a given value of the second component V.
	 * @param firstKey The value of the first component.
	 * @param secondKey The value of the second component.
	 * @return A new possibly empty collection.
	 */
	public Collection<W> get(U firstKey, V secondKey) {
		Collection<W> copy = new ArrayList<W>();
		Map<V, Collection<W>> targetMap = this.map.get(firstKey);
		if (targetMap!=null) {
			 Collection<W> target = targetMap.get(secondKey);
			 if (target!=null) copy.addAll(target);
		}
		return copy;
	}

	/**
	 * Provides a <b>copy</b> of the set of values from the first component U.
	 * @return A new possibly empty set.
	 */
	public Set<U> key1Set() {
		Set<U> copy = new HashSet<U>();
		copy.addAll(this.map.keySet());
		return copy;
	}
	
	/**
	 * Provides a <b>copy</b> of the set of values from the second component V
	 * associated to a given value of the first component U.
	 * @param firstKey The value of the first component.
	 * @return A new possibly empty set.
	 */
	public Set<V> key2Set(U firstKey) {
		Set<V> copy = new HashSet<V>();
		Map<V, Collection<W>> targetMap = this.map.get(firstKey);
		if (targetMap!=null) copy.addAll(targetMap.keySet());
		return copy;
	}
	
	/**
	 * Adds a new triplet to the set.
	 * @param firstKey The value of the first component.
	 * @param secondKey The value of the second component.
	 * @param value The value of the third component.
	 * @return true if the addition actually updates the set.
	 */
	public boolean put(U firstKey, V secondKey, W value) {
		return this.putAll(firstKey, secondKey, Collections.singleton(value));
	}
	
	/**
	 * Adds a new set of triplets to the set.
	 * @param firstKey The value of the first component.
	 * @param secondKey The value of the second component.
	 * @param values The value of the third components.
	 * @return true if the addition actually updates the set.
	 */
	public boolean putAll(U firstKey, V secondKey, Collection<? extends W> values) {
		Map<V, Collection<W>> links = this.map.get(firstKey);
		if (links==null) {
			links = new HashMap<V, Collection<W>>();
			this.map.put(firstKey, links);
		}
		Collection<W> target = links.get(secondKey);
		if (target==null) {
			target = new ArrayList<W>();
			links.put(secondKey, target);
		}
		return target.addAll(values);
	}
	
	/**
	 * Removes all the triplets with a given first component.
	 * @param firstKey The value of the first component.
	 * @return true if it actually updates the set.
	 */
	public boolean remove(U firstKey) {
		return (this.map.remove(firstKey)!=null);
	}
	
	/**
	 * Removes all the triplets with a given pair of first and second components.
	 * @param firstKey The value of the first component.
	 * @param secondKey The value of the second component.
	 * @return true if it actually updates the set.
	 */
	public boolean remove(U firstKey, V secondKey) {
		Map<V, Collection<W>> links = this.map.get(firstKey);
		if (links==null) return false;
		return (links.remove(secondKey)!=null);
	}
	
	/**
	 * Removes a given triplet.
	 * @param firstKey The value of the first component.
	 * @param secondKey The value of the second component.
	 * @param value The value of the third component.
	 * @return true if it actually updates the set.
	 */
	public boolean remove(U firstKey, V secondKey, Object value) {
		return this.removeAll(firstKey, secondKey, Collections.singleton(value));
	}
	
	/**
	 * Removes a given set of triplets with the same first and second components.
	 * @param firstKey The value of the first component.
	 * @param secondKey The value of the second component.
	 * @param values The set of values of the third component.
	 * @return true if it actually updates the set.
	 */
	public boolean removeAll(U firstKey, V secondKey, Collection<?> values) {
		Map<V, Collection<W>> links = this.map.get(firstKey);
		if (links==null) return false;
		Collection<W> target = links.get(secondKey);
		if (target==null) return false;
		if (target.removeAll(values)) {
			if (target.isEmpty()) {
				links.remove(secondKey);
				if (links.isEmpty()) this.map.remove(firstKey);
			}
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String res = "[ ";
		for(U k1 : this.map.keySet())
			for(V k2 : this.map.get(k1).keySet())
				for (W v : this.map.get(k1).get(k2)) res+=("("+k1+";"+k2+";"+v+") ");
		return (res+"]");
	}
}
