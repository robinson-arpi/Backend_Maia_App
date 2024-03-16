package com.maia.maia_app.schedule.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Timeblocks")
public class TimeBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "block_id")
    private Integer blockId;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;
}