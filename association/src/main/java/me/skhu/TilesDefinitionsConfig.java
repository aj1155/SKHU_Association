package me.skhu;

import java.util.HashMap;
import java.util.Map;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TilesDefinitionsConfig implements DefinitionsFactory{

	private static final Map<String, Definition> tilesDefinitions = new HashMap<String, Definition>();
	private static final Attribute BASE_TEMPLATE = new Attribute("/WEB-INF/views/template.jsp");

	@Override
	public Definition getDefinition(String name,Request tilesContext){
		return tilesDefinitions.get(name);
	}

	private static void addDefaultLayoutDef(String name, String content){
		Map<String, Attribute> attributes = new HashMap<String, Attribute>();

		attributes.put("header", new Attribute("/WEB-INF/views/commons/header.jsp"));
		attributes.put("menu",new Attribute("/WEB-INF/views/commons/menu.jsp"));
		attributes.put("content",new Attribute("/WEB-INF/views/"+content+".jsp"));
		tilesDefinitions.put(name, new Definition(name, BASE_TEMPLATE, attributes));
	}

	public static void addDefinitions(){
		addDefaultLayoutDef("user/list","user/list");
		addDefaultLayoutDef("user/edit","user/edit");
	}
}
