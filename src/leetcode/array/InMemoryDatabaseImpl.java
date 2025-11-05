package leetcode.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import com.sun.source.tree.Tree;

class InMemoryDatabaseImpl {
  
  HashMap<String, TreeMap<String, Record>> inmemorydb;  
  public InMemoryDatabaseImpl() {
    inmemorydb = new HashMap<>();
  }
  
  public void set(String key, String field, String value) {
    inmemorydb.putIfAbsent(key, new TreeMap<>());
    TreeMap<String, Record> keyValue = inmemorydb.get(key);
    keyValue.put(field, new Record(field, value));
  }
  
  public Optional<String> get(String key, String field) {
    if(!inmemorydb.containsKey(key)){
        return Optional.empty();
    }
    TreeMap<String, Record> keyValue = inmemorydb.get(key);
    if(!keyValue.containsKey(field)){
      return Optional.empty();
    }
    Record record = keyValue.get(field);
    return Optional.of(record.value);
  }
  
  public boolean delete(String key, String field) {
  if(!inmemorydb.containsKey(key)){
        return false;
    }
    TreeMap<String, Record> keyValue = inmemorydb.get(key);
    if(!keyValue.containsKey(field)){
      return false;
    }
    keyValue.remove(field);
    return true;
  }
  
  public List<String> scan(String key) {
    if(!inmemorydb.containsKey(key))
      return Collections.emptyList();
    
    TreeMap<String, Record> keyValue = inmemorydb.get(key);
    return Collections.emptyList();

  }
}
