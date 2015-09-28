#!/bin/bash
if [ -z "$1" ]; then
    echo "usage: $0 [sourcedir] jira-id"
    exit 1
fi
if [ -z "$2" ]; then
    source_dir='SPR-0000' # default
    target_dir=$1
else
    source_dir=$1
    target_dir=$2
fi
if [ ! -d "$source_dir" ]; then
    echo "source directory $source_dir does not exist"
    exit 2
fi
if [ -d "$target_dir" ]; then
    echo "target directory $target_dir already exists"
    exit 3
fi
# remove trailing slash
case "$source_dir" in 
    */)
        length=${#source_dir}
        source_dir=${source_dir:0:$length-1}
        ;;
esac
expr="s/$source_dir/$target_dir/"
set -x
mkdir $target_dir
cp -r $source_dir/src $target_dir/
cp $source_dir/README-template.md $target_dir/README.md
cp $source_dir/pom.xml $target_dir/
perl -p -i -e $expr $target_dir/pom.xml
perl -p -i -e $expr $target_dir/README.md
