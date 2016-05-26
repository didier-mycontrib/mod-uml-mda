package m2t.uml.gen;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.resource.UMLResource;

public class MyUmlPackageRegisterHelper {
	
	/*public static final String UML2_RESOURCES_PATH="jar:file:" +"/C:/Prog/UML/MarsPapyrus/" 
	                                              + "eclipse/plugins/org.eclipse.uml2.uml.resources_5.1.0.v20160201-0816.jar!/";*/
	/*
	public static final String UML2_RESOURCES_PATH="jar:file:" + "C:/tp/tp-uml/my_uml2_5_papyrus_models_wksp/" + 
			 "myAcceleoUmlGen/lib/org.eclipse.uml2.uml.resources_5.1.0.v20160201-0816.jar!/";*/
	
	public static final String END_UML2_RESOURCES_PATH= "/lib/org.eclipse.uml2.uml.resources_5.1.0.v20160201-0816.jar!/";

	
	
	
	
	/*
	 * NB1: la méthode statique suivante est à appeler au sein de la méthode registerPackages() 
	 * de la classe Generate.java (ou une autre de ce type).
	 * Ceci permet d'enregistrer le chemin menant au plugin eclipse qui gère les resources UML.
	 * Sans cela , certains types prédéfinis (tels que String , Integer, ...) sont mal gérés.
	 * 
	 * NB2:
	 * il faut penser à fixer @generated NOT au dessus de 
	 *    public void registerPackages(ResourceSet resourceSet) dans Generate.java
	 */
	
	public static void registerPackagesForStandalone(ResourceSet resourceSet) {
		
		String myAppPropPath = null;
		String projectPath = null;
		String uml2ResourcesPath = null;
		try {
			myAppPropPath = Thread.currentThread().getContextClassLoader().getResource("default.properties").getPath();
		} catch (Exception e) {
			   System.err.println("myApp.properties does not exist");
			   //e.printStackTrace();
		}
		try {
			if(myAppPropPath!=null){
				int i1 = myAppPropPath.lastIndexOf("/");
				String projectPathBin = myAppPropPath.substring(0, i1);
				int i2 = projectPathBin.lastIndexOf("/");
				projectPath = projectPathBin.substring(0, i2);
				uml2ResourcesPath = "jar:file:"+ projectPath +END_UML2_RESOURCES_PATH;
				System.out.println("uml2ResourcesPath="+uml2ResourcesPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        Map<URI, URI> uriMap = resourceSet.getURIConverter().getURIMap();
        //URI uri = URI.createURI(UML2_RESOURCES_PATH);
        URI uri = URI.createURI(uml2ResourcesPath);
        uriMap.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP), uri.appendSegment("libraries").appendSegment(""));
        uriMap.put(URI.createURI(UMLResource.METAMODELS_PATHMAP), uri.appendSegment("metamodels").appendSegment(""));
        uriMap.put(URI.createURI(UMLResource.PROFILES_PATHMAP), uri.appendSegment("profiles").appendSegment(""));
        
        
	}

}
