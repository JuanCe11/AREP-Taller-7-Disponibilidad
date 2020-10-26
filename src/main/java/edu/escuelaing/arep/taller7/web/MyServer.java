package edu.escuelaing.arep.taller7.web;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

import org.eclipse.jetty.util.StringUtil;

import edu.escuelaing.arep.taller7.utils.SortUtil;
import edu.escuelaing.arep.taller7.utils.StringUtils;

/**
 * The front-end server class of the application
 */
public class MyServer {

	/**
	 * Main class that starts the main thread of the service.
	 * 
	 * @param args String array
	 */
	public static void main(String[] args) {

		port(getPort());
		staticFiles.location("/public");

		get("/", (req, res) -> {
			String ls_values;
			String ls_res;
			ls_values = req.queryParams("list");
			if(StringUtil.isNotBlank(ls_values))
				ls_res = resultData(ls_values);
			else 
				ls_res = "Please add the param \"list\" to the request";
			return ls_res;
		});

	}

	/**
	 * Processes the request data
	 * 
	 * @param as_values request  data
	 * @return a string with the data processed
	 */
	private static String resultData(String as_values) {
		boolean lb_resp;
		String ls_res;
		
		lb_resp = validList(as_values);
		ls_res = null;

		if (lb_resp) {
			double[] lda_numbers;
			double[] lda_res;

			lda_numbers = StringUtils.toArray(as_values);
			lda_res = SortUtil.sort(lda_numbers);
			ls_res = StringUtils.toString(lda_res);

		}
		return ls_res;
	}

	/**
	 * Validate if a string is valid to calculate the values.
	 * 
	 * @param as_list String to validate.
	 * @return if the string is valid
	 */
	private static boolean validList(String as_list) {
		String[] lsa_parts;
		boolean lb_valid;

		lsa_parts = as_list.split(",");
		lb_valid = true;

		for (int i = 0; i < lsa_parts.length; i++) {
			try {
				Double.parseDouble(lsa_parts[i]);
			} catch (Exception e) {
				lb_valid = false;
			}
		}
		return lb_valid;
	}

	/**
	 * Specifies the port on which the service will run.
	 * 
	 * @return The port where the service will be run.
	 */
	private static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 5000;
	}
}
