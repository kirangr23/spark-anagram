import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf 

object anagram {
	
	def main(args : Arrray[String]) {
        val conf = new SparkConf().setAppName("Anagram words")
        val sc = new SparkContext(conf)
        val raw = sc.textFile("spark/test.txt")
        val rawfm = raw.flatMap(a => a.split(" ")
        val word =  rawfm.map(line => (line,line.toLowerCase.sorted))
        val sort1 = word.map{ case(a,b) => (b,a)}
        val group1 = sort1.groupByKey 
        group1.collect()

	}
}

