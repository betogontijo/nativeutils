package br.com.betogontijo.nativeutils;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class GlpkLoader {

	public static void load() {
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		String os = System.getProperty("os.name").toLowerCase();
		String arch = System.getProperty("os.arch").toLowerCase();
		String prefix = null;
		if ((os.indexOf("win") >= 0) && (arch.indexOf("64") >= 0)) {
			prefix = "/native/glpk-4.63/w64/";
		} else if ((os.indexOf("win") >= 0) && (arch.indexOf("32") >= 0)) {
			prefix = "/native/glpk-4.63/w64/";
		} else {
			prefix = "/native/glpk-4.63/l64/";
		}
		try {
			for (Resource resource : resolver.getResources("classpath*:" + prefix + "*")) {
				try {
					String library = prefix + resource.getFilename();
					NativeUtils.loadLibraryFromJar(library);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
