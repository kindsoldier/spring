#
# Copyright 2020 Oleg Borodin <borodin@unix7.org> 
#

AUTOMAKE_OPTIONS = foreign no-dependencies no-installinfo

JAR = build/libs/lorem-0.0.1.jar
DATABASE = lorem.db

if DEVEL_MODE

all: $(JAR)
	$(GRADLE) build

rebuild:
	$(GRADLE) build

migrate:
	$(SQLITE3) $(DATABASE) < schema/schema-sqlite.sql
	$(SQLITE3) $(DATABASE) < schema/data.sql

else
all:
migrate:
rebuild:

sbin_SCRIPTS = lorem

endif

run: $(JAR)
	$(JAVA) -jar $(JAR)


EXTRA_DIST = \
	README.md \
	src \
	schema \
	front/angular.json \
	front/browserslist \
	front/package-lock.json \
	front/package.json \
	front/tsconfig.app.json \
	front/tsconfig.json \
	front/tsconfig.spec.json \
	front/tslint.json \
	front/src \
	build/libs/

clean-local:
	rm -rf autom4te.cache

install-data-local:
	test -z $(DESTDIR)$(APP_LIBDIR) || $(MKDIR_P) $(DESTDIR)$(APP_LIBDIR)
	test -z $(DESTDIR)$(APP_DATABASEDIR) || $(MKDIR_P) $(DESTDIR)$(APP_DATABASEDIR)

	cp -r $(JAR) $(DESTDIR)$(APP_LIBDIR)
	cp -r $(DATABASE) $(DESTDIR)$(APP_DATABASEDIR)

#EOF
