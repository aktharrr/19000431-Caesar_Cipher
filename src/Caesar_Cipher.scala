object Caesar_Cipher extends App {

  val encryption = (c:Char,key:Int,alphabet:String) => {
    alphabet((alphabet.indexOf(c)+key)%alphabet.size)
  }

  val decryption=(c:Char,key:Int,alphabet:String)=>{
    if(alphabet.indexOf(c)<key) {
      alphabet(alphabet.indexOf(c)-key+alphabet.length())
    }
    else {
      alphabet((alphabet.indexOf(c)-key)%alphabet.size)
    }
  }

  val cipher = (f:(Char,Int,String)=>Char,text:String,key:Int,alphabet:String)=>text.map(f(_,key,alphabet))


  val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz"
  var text = "Functional Programing"

  val cc = cipher(encryption,text, 5,alphabet)
  val dc = cipher(decryption, cc, 5, alphabet)

  println("Original Text  : " + text)
  println("Encrypted Text : " + cc)
  println("Decrypted Text : " + dc)
}
