#ifndef clox_object_h
#define clox_object_h

#include "common.h"  
#include "value.h"   

#define OBJ_TYPE(value)         (AS_OBJ(value)->type)
#define IS_STRING(value)        isObjType(value, OBJ_STRING)
#define AS_STRING(value)        ((ObjString*)AS_OBJ(value))         
#define AS_CSTRING(value)       (((ObjString*)AS_OBJ(value))->chars)
typedef enum {    
  OBJ_STRING,     
} ObjType;

/**
The name “Obj” itself refers to a struct that contains the state shared across 
all object types. It’s sort of like the “base class” for objects.
**/
struct sObj {        
  ObjType type;
};

struct sObjString {
  Obj obj;         
  int length;      
  char* chars;     
};                

static inline bool isObjType(Value value, ObjType type) {
  return IS_OBJ(value) && AS_OBJ(value)->type == type;   
} 
#endif
