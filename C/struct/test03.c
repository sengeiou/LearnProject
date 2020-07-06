#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_DATA 512
#define MAX_ROWS 100

struct Address
{
    int id;
    int set;
    char name[MAX_DATA];
    char email[MAX_DATA];
};

struct Database
{
    struct Address rows[MAX_ROWS];
};

struct Connection
{
    FILE *file;
    struct Database *db;
};

void die(const char *message)
{
}

void printAddress(struct Address *addr)
{
    printf("the address is %d , %s,  %s\n", addr->id, addr->name, addr->email);
}

void Database_load(struct Connection *conn)
{
    int rc = fread(conn->db, sizeof(struct Database), 1, conn->file);
    if (rc != 1)
    {
        die("Failed to load database!");
    }
}

struct Connection *Database_open(const char *filename, char mode)
{
    struct Connection *conn = malloc(sizeof(struct Connection));
    if (!conn)
        die("Memory error");
    conn->db = malloc(sizeof(struct Database));
    conn->file = fopen(filename, mode);
    if (!conn->file)
    {
        die("failed to open the file");
    }
    return conn;
}

void Database_close(struct Connection *conn)
{
    if (conn)
    {
        if (conn->file)
        {
            fclose(conn->file);
        }
        if (conn->db)
        {
            free(conn->db);
        }
        free(conn);
    }
}

void Database_write(struct Connection* conn){
    rewind(conn->file);
    int rc  = fwrite(conn->db, sizeof(struct Database),1, conn->file);
    if(rc != 1){
        die("failed to write database.");
    }
    rc = fflush(conn-> file);
    if(rc != 1){
        die("cant flush database!");
    }
}

void Database_create(struct Connection* conn){
    int i = 0;
    for (i = 0; i < MAX_ROWS; i++)
    {
        struct Address addr = {.id = i , .set = 0};
        conn -> db -> rows[i] = addr;
    }
}

void Database_set(struct Connection* conn ,int id ,const char *name, const char* email){
    struct Address *addr = & conn->db-> rows[id];
    if(addr -> set){
        die("already set , delete it first!");
    }
    addr -> set  = 1;
    char* res  = strncpy(addr-> name ,name , MAX_DATA);
    if(!res){
        die("name copy filed!");
    }
    res = strncpy(addr-> email, email, MAX_DATA);
    if(!res){
        die("email copy failed!");
    }
}


void Database_get(struct Connection* conn ,int id){
    struct Address* addr = & conn->db->rows[id];
    if(addr-> set){
        printAddress(addr);
    }else{
        die("id is not set!");
    }
}

void Database_delete(struct Connection* conn, int id){
    struct Address addr  = {.id = id , .set = 0};
    conn-> db -> rows[id] = addr;
}

void Database_list(struct Connection *conn){
    int i = 0;
    struct Database* db = conn->db;
    for (int  i = 0; i < MAX_ROWS; i++)
    {
        struct Address* addr = &db -> rows[i];
        if(addr-> set){
            printAddress(addr);
        }
    }
}


int main()
{
    return EXIT_SUCCESS;
}