package com.example.assignment3.data

import com.example.assignment3.R
import com.example.assignment3.model.NBATeams

class Datasource() {
   fun loadDataSource(): List<NBATeams>   {
         return listOf <NBATeams>(
               NBATeams( R.string.Day1, R.string.kings,R.drawable.sacramentokings),
               NBATeams(R.string.Day2, R.string.trailblazers, R.drawable.portlandtrailblazers),
               NBATeams(R.string.Day3, R.string.raptors, R.drawable.torontoraptors),
               NBATeams(R.string.Day4, R.string.jazz, R.drawable.utahjazz),
               NBATeams(R.string.Day5, R.string.celtics, R.drawable.bostonceltics),
               NBATeams(R.string.Day6, R.string.nets, R.drawable.brooklynnets),
               NBATeams(R.string.Day7, R.string.hornets, R.drawable.charlottehornets),
               NBATeams(R.string.Day8, R.string.celtics, R.drawable.bostonceltics),
               NBATeams(R.string.Day9, R.string.bulls, R.drawable.chicagobulls),
               NBATeams(R.string.Day10, R.string.cavaliers, R.drawable.clevelandcavaliers),
               NBATeams(R.string.Day11, R.string.mavericks, R.drawable.dallasmavericks),
               NBATeams(R.string.Day12, R.string.nuggets, R.drawable.denvernuggets),
               NBATeams(R.string.Day13, R.string.pistons, R.drawable.detroitpistons),
               NBATeams(R.string.Day14, R.string.warriors, R.drawable.goldenstatewarriors),
               NBATeams(R.string.Day15, R.string.rockets, R.drawable.houstonrockets),
               NBATeams(R.string.Day16, R.string.pacers, R.drawable.indianapacers),
               NBATeams(R.string.Day17, R.string.clippers, R.drawable.losangelesclippers),
               NBATeams(R.string.Day18, R.string.lakers, R.drawable.losangeleslakers),
               NBATeams(R.string.Day19, R.string.grizzlies, R.drawable.memphisgrizzlies),
               NBATeams(R.string.Day20, R.string.heat, R.drawable.miamiheat),
               NBATeams(R.string.Day21, R.string.bucks, R.drawable.milwaukeebucks),
               NBATeams(R.string.Day22, R.string.timberwolves, R.drawable.minnesotatimberwolves),
               NBATeams(R.string.Day23, R.string.pelicans, R.drawable.neworleanspelicans),
               NBATeams(R.string.Day24, R.string.knicks, R.drawable.newyorkknicks),
               NBATeams(R.string.Day25, R.string.thunder, R.drawable.okcthunder),
               NBATeams(R.string.Day26, R.string.magic, R.drawable.orlandomagic),
               NBATeams(R.string.Day27, R.string.sixers, R.drawable.philadelphia76ers),
               NBATeams(R.string.Day28, R.string.suns, R.drawable.phoenixsuns),
               NBATeams(R.string.Day29, R.string.spurs, R.drawable.sanantoniospurs),
               NBATeams(R.string.Day30, R.string.rockets, R.drawable.houstonrockets)
         )
   }
}

