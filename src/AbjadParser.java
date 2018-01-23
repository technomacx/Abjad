/* Generated By:JavaCC: Do not edit this line. AbjadParser.java */
import nodes.AssignNode;
import nodes.ComparisionNode;
import nodes.ConstantNode;
import nodes.ExpressionNode;
import nodes.IfNode;
import nodes.Node;
import nodes.ScopeNode;
import nodes.VariableNode;
import nodes.WriteNode;

public class AbjadParser implements AbjadParserConstants {
  public static void main(String args []) throws ParseException, java.io.FileNotFoundException
  {
        AbjadParser  parser ;
    parser = new AbjadParser(System.in,"UTF-8");
    AbjadParser.Start();
  }

  static final public Node start() throws ParseException {
  Node n = null;
  ScopeNode node = new ScopeNode();
    label_1:
    while (true) {
      n = statement();
      node.addChild(n);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case FOR:
      case READ:
      case PRINT:
      case assign:
      case VAR:
      case FUN:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
    }
    jj_consume_token(0);
   {if (true) return node;}
    throw new Error("Missing return statement in function");
  }

  static final public Node statement() throws ParseException {
  Node n = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case assign:
      n = assign();
      break;
    case IF:
      ifstmt();
      break;
    case FOR:
      break_loop();
      break;
    case PRINT:
      printstmt();
      break;
    case VAR:
      defstmt();
      break;
    case FUN:
      func();
      break;
    case READ:
      Readstmt();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
         {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public void func() throws ParseException {
    jj_consume_token(FUN);
    jj_consume_token(ID);
    jj_consume_token(LP);
    jj_consume_token(ID);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FAS:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      jj_consume_token(FAS);
      jj_consume_token(ID);
    }
    jj_consume_token(RP);
    jj_consume_token(41);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      break;
    case Float:
      jj_consume_token(Float);
      break;
    case Char:
      jj_consume_token(Char);
      break;
    case bool:
      jj_consume_token(bool);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(42);
    label_3:
    while (true) {
      statement();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case FOR:
      case READ:
      case PRINT:
      case assign:
      case VAR:
      case FUN:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_3;
      }
    }
    jj_consume_token(43);
  }

  static final public Node assign() throws ParseException {
  AssignNode node = new AssignNode();
  Node n = null;
  Token t;
    t = jj_consume_token(assign);
    jj_consume_token(ID);
    jj_consume_token(ASSIGN);
    n = E();
    node.setVariable(t.image);
    node.addChild(n);
    {if (true) return node;}
    throw new Error("Missing return statement in function");
  }

  static final public void printstmt() throws ParseException {
  WriteNode node = new WriteNode();
  Token t;
  ExpressionNode  n1 = null;
    t = jj_consume_token(PRINT);
    n1 = E();
    //node.setVariable(n1);
    System.out.println(n1.getResult());
        //return node;

  }

  static final public ComparisionNode comp() throws ParseException {
  ComparisionNode node = new ComparisionNode();
  Node n1=null,n2=null;
  Token t;
    n1 = E();
    t = jj_consume_token(COMP);
    n2 = E();
    node.setOperation(t.image);
    node.addChild(n1);
    node.addChild(n2);
    {if (true) return node;}
    throw new Error("Missing return statement in function");
  }

  static final public IfNode ifstmt() throws ParseException {
  IfNode node = new IfNode();
  Node n = null;
  ScopeNode n1 = new ScopeNode(),n2 = null;
    jj_consume_token(IF);
    n = comp();
    node.addChild(n);
    label_4:
    while (true) {
      n = statement();
            n1.addChild(n);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case FOR:
      case READ:
      case PRINT:
      case assign:
      case VAR:
      case FUN:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_4;
      }
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      jj_consume_token(ELSE);
      n2 = new ScopeNode();
      n = statement();
         n2.addChild(n);
      break;
    case ELIF:
      jj_consume_token(ELIF);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    node.addChild(n1);
    if (n2 != null)
        node.addChild(n2);
    {if (true) return node;}
    throw new Error("Missing return statement in function");
  }

  static final public void forstmt() throws ParseException {
    jj_consume_token(WHILE);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LP:
      jj_consume_token(LP);
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
    comp();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RP:
      jj_consume_token(RP);
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    jj_consume_token(42);
    label_5:
    while (true) {
      statement();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case FOR:
      case READ:
      case PRINT:
      case assign:
      case VAR:
      case FUN:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_5;
      }
    }
    jj_consume_token(43);
  }

  static final public void break_loop() throws ParseException {
    jj_consume_token(FOR);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case WHILE:
      forstmt();
      break;
    case 42:
      doWhilestmt();
      break;
    case VAR:
    case OF:
      whilestmt();
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void doWhilestmt() throws ParseException {
    jj_consume_token(42);
    label_6:
    while (true) {
      statement();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case FOR:
      case READ:
      case PRINT:
      case assign:
      case VAR:
      case FUN:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_6;
      }
    }
    jj_consume_token(43);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LP:
      jj_consume_token(LP);
      break;
    default:
      jj_la1[12] = jj_gen;
      ;
    }
    comp();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RP:
      jj_consume_token(RP);
      break;
    default:
      jj_la1[13] = jj_gen;
      ;
    }
  }

  static final public void whilestmt() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OF:
      jj_consume_token(OF);
      defstmt();
      jj_consume_token(ASSIGN);
      jj_consume_token(NUM);
      jj_consume_token(TO);
      jj_consume_token(NUM);
      break;
    case VAR:
      defstmt();
      jj_consume_token(ASSIGN);
      jj_consume_token(NUM);
      jj_consume_token(TO);
      jj_consume_token(NUM);
      jj_consume_token(ONCE);
      jj_consume_token(42);
      label_7:
      while (true) {
        statement();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IF:
        case FOR:
        case READ:
        case PRINT:
        case assign:
        case VAR:
        case FUN:
          ;
          break;
        default:
          jj_la1[14] = jj_gen;
          break label_7;
        }
      }
      jj_consume_token(43);
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Readstmt() throws ParseException {
    jj_consume_token(READ);
    label_8:
    while (true) {
      E();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUM:
      case LP:
      case ID:
        ;
        break;
      default:
        jj_la1[16] = jj_gen;
        break label_8;
      }
    }
  }

  static final public void defstmt() throws ParseException {
    jj_consume_token(VAR);
    jj_consume_token(ID);
    jj_consume_token(CLMN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
    case Float:
    case Char:
    case bool:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT:
        jj_consume_token(INT);
        break;
      case Float:
        jj_consume_token(Float);
        break;
      case bool:
        jj_consume_token(bool);
        break;
      case Char:
        jj_consume_token(Char);
        break;
      default:
        jj_la1[17] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case Pointer:
      jj_consume_token(Pointer);
      jj_consume_token(TO);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT:
        jj_consume_token(INT);
        break;
      case Float:
        jj_consume_token(Float);
        break;
      case bool:
        jj_consume_token(bool);
        break;
      case Char:
        jj_consume_token(Char);
        break;
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Start() throws ParseException {
    label_9:
    while (true) {
      statement();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case FOR:
      case READ:
      case PRINT:
      case assign:
      case VAR:
      case FUN:
        ;
        break;
      default:
        jj_la1[20] = jj_gen;
        break label_9;
      }
    }
    System.out.println("OK!");
  }

  static final public ExpressionNode E() throws ParseException {
  ExpressionNode n1 =null,n2 = null;
  Token t = null;
    n1 = F();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      t = jj_consume_token(PLUS);
      n2 = E();
      break;
    default:
      jj_la1[21] = jj_gen;
      ;
    }
          if (n2 == null)
                {if (true) return n1;}
          else
          {
                ExpressionNode node = new ExpressionNode();
                node.setOperation(t.image);
                node.addChild(n1);
                node.addChild(n2);
                {if (true) return node;}
          }
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode F() throws ParseException {
  ExpressionNode n1,n2 = null;
  Token t = null;
    n1 = N();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MULTIPLY:
      t = jj_consume_token(MULTIPLY);
      n2 = F();
      break;
    default:
      jj_la1[22] = jj_gen;
      ;
    }
          if (n2 == null)
                {if (true) return n1;}
          else
          {
                ExpressionNode node = new ExpressionNode();
                node.setOperation(t.image);
                node.addChild(n1);
                node.addChild(n2);
                {if (true) return node;}
          }
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode N() throws ParseException {
  ExpressionNode n = new ExpressionNode() ;
  Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUM:
      t = jj_consume_token(NUM);
    ConstantNode cn = new ConstantNode();
    cn.setConstant(Double.parseDouble(t.image));
    n = cn;
      break;
    case LP:
      jj_consume_token(LP);
      n = E();
      jj_consume_token(RP);
      break;
    case ID:
      t = jj_consume_token(ID);
    VariableNode vn = new VariableNode();
    vn.setVariable(t.image);
    n = vn;
      break;
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
     {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public AbjadParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[24];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xd00e400,0xd00e400,0x20000000,0xb80000,0xd00e400,0xd00e400,0x40800,0x80,0x100,0xd00e400,0x84001000,0xd00e400,0x80,0x100,0xd00e400,0x84000000,0xc0,0xb80000,0xb80000,0xf80000,0xd00e400,0x0,0x0,0xc0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x400,0x0,0x0,0x0,0x0,0x0,0x100,0x0,0x0,0x0,0x0,0x2,0x4,0x100,};
   }

  /** Constructor with InputStream. */
  public AbjadParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public AbjadParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new AbjadParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public AbjadParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AbjadParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public AbjadParser(AbjadParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(AbjadParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[44];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 24; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 44; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
