package leetcode.array;


  import java.util.HashMap;
  import java.util.Optional;
  import java.util.List;
  import java.util.stream.Collectors;

  class CloudStorageImpl {
    
    HashMap<String, File> fileSystem;
    public CloudStorageImpl() {
      fileSystem = new HashMap<>();
    }

    public boolean addFile(String name, int size) {
      if(fileSystem.containsKey(name)){
        return false;
      }
      fileSystem.put(name, new File(name, size));
      return true;
  }

  public Optional<Integer> getFileSize(String name) {
      if(!fileSystem.containsKey(name)){
        return Optional.empty();
      }
      
      return Optional.of(fileSystem.get(name).size);
    }
    
    public Optional<Integer> deleteFile(String name) {
      if(!fileSystem.containsKey(name)){
        return Optional.empty();
      }
      File f = fileSystem.remove(name);
      return Optional.of(f.size);
    }
    
    public List<String> getNLargest(String prefix, int n) {
      return fileSystem.values().stream().filter(f->f.name.startsWith(prefix)).sorted((o1,o2)->{
        if(o1.size != o2.size){
          return Integer.compare(o2.size, o1.size);
        }
        else{
          return o1.name.compareTo(o2.name);
        }
      }).limit(n).map(f->f.name+"("+f.size+")").collect(Collectors.toList());
    }
  }
