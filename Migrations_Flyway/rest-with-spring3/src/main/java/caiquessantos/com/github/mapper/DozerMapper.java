package caiquessantos.com.github.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

/**
 * Classe responsável por trasnformar entitys em VO
 * */
public class DozerMapper {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	//retorna um objeto destino
	public static <Origem, Destino> Destino parseObject(Origem origem, 	Class<Destino> destino) {
		return mapper.map(origem, destino);
	}
	
	
	//Retorna uma lista de objetos destino
	public static <Origem, Destino> List<Destino> parseListObjects(List<Origem> origem
			, Class<Destino> destino) {
		List<Destino> objetosDestino = new ArrayList<>();
		for (Origem o : origem) {
			objetosDestino.add(mapper.map(o, destino));
		}
		return objetosDestino;
	}
}
