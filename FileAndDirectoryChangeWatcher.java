/**
 * Watch dir change
 * 监视文件夹是否有改动
 * 
 * @param path directory path 文件夹路径
 * @param shutdown	shutdown condition 关闭条件
 */
public void WatchDir(String path, boolean shutdown) {
	Path dir = Paths.get(path);
	try {
		WatchService watcher = FileSystems.getDefault().newWatchService();
		WatchKey key = dir.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);
		while (!shutdown) {
			key = watcher.take();
			for (WatchEvent<?> event : key.pollEvents()) {
				if (event.kind() == (StandardWatchEventKinds.ENTRY_MODIFY)) {
					System.out.println("dir changed");
					//TODO: do some thing for the change
					
				}
			}
			key.reset();
		}
	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

/**
 * watch file change，both in premission properties and content 
 * 监视文件是否改动
 *
 * @param filepath  file path 文件路径
 * @param shutdown	shutdown condition 关闭条件
 * @throws IOException
 */
public void WatchFileChange(Path filepath, boolean shutdown) throws IOException {
	AclFileAttributeView attr = Files.getFileAttributeView(filepath, AclFileAttributeView.class);
	List<AclEntry> listattr = attr.getAcl();
	FileTime lastModified = Files.getLastModifiedTime(filepath);
	while (!shutdown) {
		boolean changed = false;
		AclFileAttributeView cur = Files.getFileAttributeView(filepath, AclFileAttributeView.class);
		FileTime curTime = Files.getLastModifiedTime(filepath);
		if (curTime.toMillis() - lastModified.toMillis() > 0) {
			changed = true;
			lastModified = curTime;
		}
		if (attr != null && cur != null && !changed) {
			List<AclEntry> curList = cur.getAcl();
			for (int i = 0; i < listattr.size(); i++) {
				if (!curList.get(i).toString().equals(listattr.get(i).toString())) {
					changed = true;
				}
			}
		}

		if (changed) {
			System.out.println("Changed");
			
			//TODO: do some thing for the change
			
			
			changed = false;
		}
	}
}