-= game plan =-

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
                // сделать таблицу дробных
            сделать таблицу целояисленных
            
