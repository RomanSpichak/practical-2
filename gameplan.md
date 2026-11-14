-= game plan =-

class App (main) {
    Properties applicationProperties = Loader.getApplicationProperties()
        загрузка application properties external/internal
           
    String table = TableBuilder.getTableAsString(applicationProperties)
        две ветки long и double, StringBuilder + String.format
    
    String serialized = Serialized.getSerializedAsString(table)
    logger info (serialized)


TableBuilder 
    
    (ROOT METHOD)
    public static String getTableInString (properties)
        if (isCorrectData(properties)) 
            return buildTable(properties)
        log.debug("Debug - properties data is not correct")
        rerurn "Properties data is not correct"

        (CHILD METHODS)
        private static boolean isCorrectData(properties)
            number format or some symbol try catch
            increment > 0
            max > 0
            max > min
        private static boolean isFractionalNumber(String type)
            return DOUBLE || FLOAT;
        private static String buildTable (properties)
            сделать шапку таблицы
            if (isFractionalNumber) 
                // code сделать таблицу дробных
                return
            // code сделать таблицу целочисленных
            return
